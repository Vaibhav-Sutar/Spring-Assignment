package com.example.crudtask_accio.service;

import com.example.crudtask_accio.dto.Request.CustomerRequestDto;
import com.example.crudtask_accio.dto.Responce.CustomerResponseDto;
import com.example.crudtask_accio.exception.CustomerAlreadyExists;
import com.example.crudtask_accio.exception.CustomerNotFound;
import com.example.crudtask_accio.mapper.CustomerMapper;
import com.example.crudtask_accio.model.Customer;
import com.example.crudtask_accio.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
     public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto, boolean SyncDb){
        Customer customer = customerRepository.findByEmail(customerRequestDto.getEmail());
        CustomerResponseDto customerResponse = new CustomerResponseDto();
        if (SyncDb && customer != null){
            customerResponse = updateCustomer(customerRequestDto.getEmail(), customerRequestDto);
        } else if (customer != null) {
            throw new CustomerAlreadyExists("found an existing account with the same email");
        } else {
            customer = CustomerMapper.customerRequestDtoToCustomer(customerRequestDto);
            customer.setUid(String.valueOf(UUID.randomUUID()));
            Customer savedCustomer = customerRepository.save(customer);      // save the customer obj to db
            customerResponse = CustomerMapper.customerToCustomerResponseDto(savedCustomer);
            customerResponse.setMessage("user Account created successfully");
        }
        return customerResponse;
    }

    @Override
    public CustomerResponseDto updateCustomer(String emailId, CustomerRequestDto customerRequestDto){
        Customer existingCustomer = customerRepository.findByEmail(emailId);
        if (existingCustomer == null) {
            throw new CustomerNotFound("Account not found with " + emailId);
        }
        if (customerRequestDto.getFirstName() != null){
            existingCustomer.setFirstName(customerRequestDto.getFirstName());
        }
        if (customerRequestDto.getLastName() != null){
            existingCustomer.setLastName(customerRequestDto.getLastName());
        }
        if (customerRequestDto.getStreet() != null){
            existingCustomer.setStreet(customerRequestDto.getStreet());
        }
        if (customerRequestDto.getAddress() != null){
            existingCustomer.setAddress(customerRequestDto.getAddress());
        }
        if (customerRequestDto.getCity() != null){
            existingCustomer.setCity(customerRequestDto.getCity());
        }
        if (customerRequestDto.getState() != null){
            existingCustomer.setState(customerRequestDto.getState());
        }
        if (customerRequestDto.getPhone() != null){
            existingCustomer.setPhone(customerRequestDto.getPhone());
        }
        if (customerRequestDto.getEmail() != null){
            existingCustomer.setEmail(customerRequestDto.getEmail());
        }
        Customer savedCustomer = customerRepository.save(existingCustomer);
        CustomerResponseDto customerResponseDto = CustomerMapper.customerToCustomerResponseDto(savedCustomer);
        customerResponseDto.setMessage("user info updated successfully");

        return customerResponseDto;
    }
    @Override
    public Page<CustomerResponseDto> getAllCustomers(int pageNo, int rowsCount, String sortBy, String searchBy){
        Pageable currentPageWithRequiredRows;
        if (sortBy != null) {
             currentPageWithRequiredRows = PageRequest.of(pageNo-1, rowsCount, Sort.by(sortBy));
        }else {
            currentPageWithRequiredRows = PageRequest.of(pageNo-1, rowsCount);
        }
        Page<Customer> customersPage = customerRepository.findAll(currentPageWithRequiredRows);
        return customersPage.map(this::convertToDto);
    }

    @Override
    public List<CustomerResponseDto> searchByCol(String searchBy, String searchQuery) {
        List<Customer> searchRes = new ArrayList<>();
        if (searchBy.equals("firstName")) {
            searchRes = customerRepository.findByFirstNameLike(searchQuery);
        } else if (searchBy.equals("city")) {
            searchRes = customerRepository.findByCityLike(searchQuery);
        } else if (searchBy.equals("phone")) {
            searchRes = customerRepository.findByPhoneLike(searchQuery);
        } else if (searchBy.equals("email")) {
            searchRes = customerRepository.findByEmailLike(searchQuery);
        }
        List<CustomerResponseDto> searchList = new ArrayList<>();

        for (Customer cust: searchRes) {
            searchList.add(CustomerMapper.customerToCustomerResponseDto(cust));
        }
        return searchList;
    }

    public CustomerResponseDto convertToDto(Customer customer){
        return CustomerMapper.customerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto getCustomerWithId(String email){
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new CustomerNotFound("no account found with the given email");
        }

        CustomerResponseDto customerResponseDto = CustomerMapper.customerToCustomerResponseDto(customer);
        customerResponseDto.setMessage("account found with " + email);
        return customerResponseDto;
    }

    @Override
    @Transactional
    public String deleteCustomer(String email){
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new CustomerNotFound("no account found with " + email);
        }
        customerRepository.deleteByEmail(email);

        return "account deleted";
    }
}
