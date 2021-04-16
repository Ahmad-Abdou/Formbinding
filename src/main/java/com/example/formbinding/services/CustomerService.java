package com.example.formbinding.services;

import com.example.formbinding.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    public Customer saveOrUpdate(Customer customer);

    public List<Customer> getAll();

    public List<Customer> findByEmail(String email);

}
