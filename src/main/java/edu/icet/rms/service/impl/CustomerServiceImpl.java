package edu.icet.rms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.rms.entity.CustomerEntity;
import edu.icet.rms.model.Customer;
import edu.icet.rms.repository.CustomerRepository;
import edu.icet.rms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ObjectMapper mapper;

    @Override
    public Customer persist(CustomerEntity customerEntity) {
        return mapper.convertValue(
                customerRepository.save(customerEntity), Customer.class);
    }

    @Override
    public List<Customer> retrieveAll() {
        List<Customer> customerList = new ArrayList<>();

        Iterable<CustomerEntity> customerEntities = customerRepository.findAll();
        customerEntities.forEach(customerEntity ->
                customerList.add(mapper.convertValue(customerEntity, Customer.class)));
        return customerList;
    }

    @Override
    public Customer update(CustomerEntity customerEntity) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }

    @Override
    public Customer searchById(Long id) {
        return null;
    }
}
