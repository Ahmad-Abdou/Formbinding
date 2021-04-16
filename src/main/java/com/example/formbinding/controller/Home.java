package com.example.formbinding.controller;

import com.example.formbinding.dto.Customer;

import com.example.formbinding.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;


@Controller
public class Home {

    CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/accountInfo")
    public String accountInfo(Model model){
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customerList",customerList);
        return "accountInfo";
    }

    @GetMapping("/")
    public String customer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "home";
    }

    @PostMapping("/account/post/")
    public String post(@ModelAttribute("customer") Customer customer){
        System.out.println(customer);

       customerService.saveOrUpdate(customer);
        return "redirect:/accountInfo";
    }
}
