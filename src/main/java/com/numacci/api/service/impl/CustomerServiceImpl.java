package com.numacci.api.service.impl;

import com.numacci.api.model.Customer;
import com.numacci.api.model.Order;
import com.numacci.api.repository.CustomerRepository;
import com.numacci.api.service.CustomerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository repository;

  public CustomerServiceImpl(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Customer getCustomerById(String customerId) {
    return repository.findByCustomerId(customerId);
  }

  @Override
  public List<Customer> getCustomerByGenderAndPostCode(String gender, String postCode) {
    return repository.findByGenderAndPostCode(gender, postCode);
  }

  @Override
  public List<Customer> getCustomerRecentlyOrdered(LocalDate from, LocalDate to) {
    return repository.findByOrdersOrderDateBetween(from, to);
  }

  @Override
  public List<Customer> getCustomerOrderedHighPrice(int minPrice) {
    return repository.findByTotalPriceGt(minPrice);
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return repository.save(customer);
  }

  @Override
  public Customer createOrder(String customerId, Order order) {
    Customer customer = repository.findByCustomerId(customerId);
    customer.getOrders().add(order);
    return repository.save(customer);
  }

  @Override
  public Customer updateCustomer(String customerId, Customer customer) {
    Customer newCustomer = repository.findByCustomerId(customerId);

    // Set values if the field of requested customer object is not null or zero.
    if (customer.getCustomerName() != null) newCustomer.setCustomerName(customer.getCustomerName());
    if (customer.getAge() > 0) newCustomer.setAge(customer.getAge());
    if (customer.getPostCode() != null) newCustomer.setPostCode(customer.getPostCode());
    if (customer.getAddress() != null) newCustomer.setAddress(customer.getAddress());

    return repository.save(newCustomer);
  }

  @Override
  public String deleteCustomer(String customerId) {
    String objectId = repository.findByCustomerId(customerId).getId();
    repository.deleteById(objectId);
    return customerId;
  }
}
