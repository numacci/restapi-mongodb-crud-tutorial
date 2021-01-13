package com.numacci.api.service;

import com.numacci.api.model.Customer;
import com.numacci.api.model.Order;
import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

  Customer getCustomerById(String customerId);

  List<Customer> getCustomerByGenderAndPostCode(String gender, String postCode);

  List<Customer> getCustomerRecentlyOrdered(LocalDate from, LocalDate to);

  List<Customer> getCustomerOrderedHighPrice(int minPrice);

  Customer createCustomer(Customer customer);

  Customer createOrder(String id, Order order);

  Customer updateCustomer(String id, Customer customer);

  String deleteCustomer(String id);
}
