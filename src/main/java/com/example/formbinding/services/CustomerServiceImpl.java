package com.example.formbinding.services;

import com.example.formbinding.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer saveOrUpdate(Customer customer) {
        Customer customer1 = new Customer();
          customer1.setEmail(customer.getEmail());
        return customer1;
    }

    @Override
    public List<Customer> getAll() {

        return customerList;
    }

    @Override
    public List<Customer> findByEmail(String email) {
        List<Customer> customers = new ArrayList<>();

        for(Customer customer1 : customerList){
            if(customer1.getEmail() == email){
                customers.add(customer1);
            }
        }

        return customers;
    }
}
