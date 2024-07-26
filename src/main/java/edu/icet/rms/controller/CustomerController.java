package edu.icet.rms.controller;

import edu.icet.rms.entity.CustomerEntity;
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
    public Customer persist(@RequestBody CustomerEntity customerEntity) {
        return customerService.persist(customerEntity);
    }

    @GetMapping("/retrieve-all")
    public List<Customer> retrieveAll() {
        return customerService.retrieveAll();
    }

    @PutMapping("/update")
    public Customer update(@RequestBody CustomerEntity customerEntity) {
        return customerService.update(customerEntity);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap("DELETE", customerService.deleteById(id));
    }

}
