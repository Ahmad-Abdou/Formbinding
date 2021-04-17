package com.example.formbinding.controller;

import com.example.formbinding.dto.Customer;
import com.example.formbinding.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;



@Controller
public class Home {

    CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/")
    public String Home(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "home";
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




    @PostMapping("/account/post/")
    public String post(@ModelAttribute("customer")  Customer customer , BindingResult bindingResult){
        if (customer.getEmail().length() < 10 || customer.getEmail().length() > 50) {
            FieldError fieldError = new FieldError("customer", "email", "Email must be atleast 10 characters");
            bindingResult.addError(fieldError);
        }
        if (!customer.getEmail().endsWith("@gmail.com")) {
            FieldError fieldError = new FieldError("customer", "email", "Email must be end with @gamil.com");
            bindingResult.addError(fieldError);
        }

        if(customer.getDetails().getCity().length() == 0   ){
            FieldError fieldError = new FieldError("customer","details.city","Please enter valid city name, it Can't be 0 ");
            bindingResult.addError(fieldError);
        }
        if(customer.getDetails().getStreet().length() ==0){
            FieldError fieldError = new FieldError("customer","details.street","Please Enter a valid street");
            bindingResult.addError(fieldError);
        }
        if(customer.getDetails().getZipCode().length() ==0 || customer.getDetails().getZipCode().length()>5){
            FieldError fieldError = new FieldError("customer","details.zipCode","Please Enter a valid Zipcode, it must be between 0 and 5");
            bindingResult.addError(fieldError);
        }
        if(customer.getDetails().getHomePhone().length() ==0 || customer.getDetails().getHomePhone().length() >9 ){
            FieldError fieldError = new FieldError("customer","details.homePhone","Please Enter a valid Home phone.");
            bindingResult.addError(fieldError);
        }
        if(customer.getDetails().getCellPhone().length() ==0 || customer.getDetails().getCellPhone().length() >9 ){
            FieldError fieldError = new FieldError("customer","details.cellPhone","Please Enter a valid Cell phone.");
            bindingResult.addError(fieldError);
        }
        if(bindingResult.hasErrors()){
            return "home";
        }
        System.out.println(customer);
       customerService.saveOrUpdate(customer);
        return "redirect:/accountInfo";
    }

}
