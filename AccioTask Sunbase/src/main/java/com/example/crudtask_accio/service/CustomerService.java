package com.example.crudtask_accio.service;

import com.example.crudtask_accio.dto.Request.CustomerRequestDto;
import com.example.crudtask_accio.dto.Responce.CustomerResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto, boolean SyncDb);

    CustomerResponseDto updateCustomer(String email, CustomerRequestDto customerRequestDto);

    Page<CustomerResponseDto> getAllCustomers(int pageNo, int rowsCount, String sortBy, String searchBy);

    List<CustomerResponseDto> searchByCol(String searchBy, String searchQuery);

    CustomerResponseDto getCustomerWithId(String email);

    String deleteCustomer(String email);

}
