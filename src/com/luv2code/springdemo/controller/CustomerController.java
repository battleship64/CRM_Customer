package com.luv2code.springdemo.controller;


import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject DAO into customer dao into controller
    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listCustomers(Model theModel){


        //get customers from the dao

        //add customers to the model

        List<Customer> theCustomers = customerService.getCustomers();

        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        //save the Customer using service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFromForUpdate(@RequestParam("customerId") int theId,Model theModel){
        //get the customer from service
        //set customer as a model attribute to pre-populate the form
        //sent to form
        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        //get the customer from service
        //delete customer
        //rediect to customer list
        customerService.deleteCustomer(theId);



        return "redirect:/customer/list";

    }
}
