package com.example.formbinding.controller;

import com.example.formbinding.dto.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    private List<Customer> customerList;

    @PostConstruct
    public void list(){
        customerList = new ArrayList<>();
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/accountInfo")
    public String accountInfo(){
        return "accountInfo";
    }



    @GetMapping("/customer/list")
    public String account(Model model){
        model.addAttribute("customerList",customerList);
        return "accountInfo";
    }
    @GetMapping("/customer")
    public String customer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "accountInfo";
    }

    @PostMapping("/account/post/")
    public String post(Customer customer , RedirectAttributes redirectAttributes){
        customerList.add(customer);
        return "redirect:/accountInfo";
    }


}
