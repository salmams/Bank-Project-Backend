package com.project.bank.service;
import java.util.List;
// import org.hibernate.mapping.List;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bank.entity.Customer;
import com.project.bank.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    // @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customer){
        return customerRepository.saveAll(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }


    public Customer getCustomerById(int id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByPhone(String phone){
        return customerRepository.findByPhone(phone);
    }

    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer deleted " +id;
    }

    public Customer updateCustomer(Customer customer){
        Customer exiCustomer= customerRepository.findById(customer.getId()).orElse(null);
        exiCustomer.setName(customer.getName());
        exiCustomer.setPhone(customer.getPhone());
        // exiCustomer=setName(customer.getName());
        return customerRepository.save(exiCustomer);
    }
}
