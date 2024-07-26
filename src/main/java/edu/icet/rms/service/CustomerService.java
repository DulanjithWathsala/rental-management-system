package edu.icet.rms.service;

import edu.icet.rms.entity.CustomerEntity;
import edu.icet.rms.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer persist(CustomerEntity customerEntity);

    List<Customer> retrieveAll();

    Customer update(CustomerEntity customerEntity);

    String deleteById(Long id);

    Customer searchById(Long id);
}
