package edu.icet.rms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.rms.entity.CustomerEntity;
import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.exception.ObjectNotFoundException;
import edu.icet.rms.model.Customer;
import edu.icet.rms.repository.CustomerRepository;
import edu.icet.rms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ObjectMapper mapper;

    @Override
    public Customer persist(Customer customer) {
        return mapper.convertValue(customerRepository.save(
                mapper.convertValue(customer, CustomerEntity.class)),
                Customer.class);
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
    public Customer update(Customer customer) {
        if (!customerRepository.existsById(customer.getCustomerId())) {
            throw new ObjectNotFoundException("Customer not found");
        }
        return mapper.convertValue(customerRepository.save(
                        mapper.convertValue(customer, CustomerEntity.class)),
                Customer.class);
    }

    @Override
    public String deleteById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return "SUCCESS";
        }
        return "FAILED";
    }

    @Override
    public Customer searchById(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if (customerEntity.isEmpty()) {
            throw new ObjectNotFoundException("Customer not found");
        }
        return mapper.convertValue(customerEntity.get(), Customer.class);
    }

    @Override
    public List<Long> retrieveAllIds() {
        List<Long> idList = new ArrayList<>();

        Iterable<CustomerEntity> entities = customerRepository.findAll();
        entities.forEach(hardwareItemEntity -> idList.add(hardwareItemEntity.getCustomerId()));
        return  idList;
    }
}
