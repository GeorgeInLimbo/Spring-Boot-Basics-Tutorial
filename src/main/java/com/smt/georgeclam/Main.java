package com.smt.georgeclam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/****
 <b>Title:</b> Main<br>
 <b>Project:</b> area51club<br>
 <b>Description:</b> <br>
 <b>Copyright:</b> Copyright (c) 2023<br>
 <b>Company:</b> Silicon Mountain Technologies<br>
 @author George Clam
 @version 1.0
 @since 3/27/23
 @updates: ****/

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/update/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id,
                               @RequestBody Map<String, String> body) {
        Customer customer = new Customer();
        customer.setName(body.get("name"));
        customer.setEmail(body.get("email"));
        customer.setAge(Integer.parseInt(body.get("age")));
        customerRepository.save(customer);
    }

}
