package com.project.bank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.entity.Customer;
import com.project.bank.service.CustomerService;

// import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    private final CustomerService customerService;

    // @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return customerService.saveCustomers(customers);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customer/phone/{phone}")
    public Customer findCustomerByPhone(@PathVariable String phone){
        return customerService.getCustomerByPhone(phone);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer user) {
        System.out.println("Received login request for user: " + user.getPhone());
        Customer storedUser = customerService.getCustomerByPhone(user.getPhone());

        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            System.out.println("Login successful for user: " + user.getPhone());
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(storedUser.getId()));
        } else {
            System.out.println("Login failed for user: " + user.getPhone());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }

    // @GetMapping("/currentCustomer")
    // public ResponseEntity<Integer> getCurrentCustomer(@RequestParam String customername) {
    //     Customer customer = customerService.getCustomerByName(customername);

    //     if (customer != null) {
    //         Integer customerId = customer.getId(); // Use Integer if id is of type int
    //         return ResponseEntity.ok(customerId);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    //     }
    // }
}
