package edu.icet.rms.service;

import edu.icet.rms.entity.CustomerEntity;
import edu.icet.rms.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer persist(Customer customer);

    List<Customer> retrieveAll();

    Customer update(Customer customer);

    String deleteById(Long id);

    Customer searchById(Long id);
}
