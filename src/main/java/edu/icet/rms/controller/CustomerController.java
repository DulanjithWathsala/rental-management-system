package edu.icet.rms.controller;

import edu.icet.rms.model.Customer;
import edu.icet.rms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public Customer persist(@RequestBody Customer customer) {
        return customerService.persist(customer);
    }

    @GetMapping("/retrieve-all")
    public List<Customer> retrieveAll() {
        return customerService.retrieveAll();
    }

    @GetMapping("/retrieve-all-ids")
    public List<Long> retrieveAllIds() {
        return customerService.retrieveAllIds();
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap("DELETE", customerService.deleteById(id));
    }

}
