package com.example.crudtask_accio.controller;

import com.example.crudtask_accio.dto.Request.CustomerRequestDto;
import com.example.crudtask_accio.dto.Responce.CustomerResponseDto;
import com.example.crudtask_accio.exception.CustomerAlreadyExists;
import com.example.crudtask_accio.exception.CustomerNotFound;
import com.example.crudtask_accio.security.JwtHelperClass;
import com.example.crudtask_accio.service.ApiService;
import com.example.crudtask_accio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtHelperClass helperClass;

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto, @RequestParam boolean SyncDb){
        try{
            CustomerResponseDto customerResponseDto = customerService.createCustomer(customerRequestDto, SyncDb);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
        }catch (CustomerAlreadyExists e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{emailId}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String emailId, @RequestBody CustomerRequestDto customerRequestDto){
        try{
            CustomerResponseDto customerResponseDto = customerService.updateCustomer(emailId, customerRequestDto);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.ACCEPTED);
        }catch(CustomerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<Page<CustomerResponseDto>> getAllCustomers(@RequestParam int pageNo, @RequestParam int rowsCount, @RequestParam(required = false)String sortBy, @RequestParam(required = false) String searchBy){

        Page<CustomerResponseDto> customerList = customerService.getAllCustomers(pageNo, rowsCount, sortBy, searchBy);
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);

    }

    @GetMapping("/searchBy")
    public ResponseEntity<List<CustomerResponseDto>> searchByCol(@RequestParam String searchBy, @RequestParam String searchQuery){
        List<CustomerResponseDto> result = customerService.searchByCol(searchBy, searchQuery);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }


    @GetMapping("/get/{email}")
    public ResponseEntity<CustomerResponseDto> getCustomerWithId(@PathVariable String email){

        try{
            CustomerResponseDto customerResponseDto = customerService.getCustomerWithId(email);
            return new ResponseEntity<CustomerResponseDto>(customerResponseDto, HttpStatus.FOUND);
        }catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@RequestParam String email){
        try {
            String result = customerService.deleteCustomer(email);
            return new ResponseEntity(result, HttpStatus.ACCEPTED);
        }catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    ApiService apiService = new ApiService();
    @GetMapping("/syncDB")
    public Object[] getToken(){
        Object[] customers = apiService.getToken();
        return customers;
    }


}
