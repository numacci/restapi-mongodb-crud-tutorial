package com.numacci.api.controller;

import com.numacci.api.model.Customer;
import com.numacci.api.model.Order;
import com.numacci.api.service.CustomerService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable String id) {
    return customerService.getCustomerById(id);
  }

  @GetMapping
  public List<Customer> getCustomerByConditions(@RequestParam Map<String, String> requestParams) {
    // Search customers by their gender and postCode.
    String gender = requestParams.get("gender");
    String postCode = requestParams.get("postCode");
    if (gender != null && postCode != null) {
      return customerService.getCustomerByGenderAndPostCode(gender, postCode);
    }

    // Search customers recently ordered in this site.
    String fromDate = requestParams.get("from");
    String toDate = requestParams.get("to");
    if (fromDate != null && toDate != null) {
      LocalDate from = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      LocalDate to = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      return customerService.getCustomerRecentlyOrdered(from, to);
    }

    // Search customers who ordered expensive products.
    String minPrice = requestParams.get("minPrice");
    if (minPrice != null) {
      return customerService.getCustomerOrderedHighPrice(Integer.parseInt(minPrice));
    }

    return new ArrayList<>();
  }

  @PostMapping
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

  @PostMapping("/{id}/orders")
  public Customer createOrder(@PathVariable String id, @RequestBody Order order) {
    return customerService.createOrder(id, order);
  }

  @PatchMapping("/{id}")
  public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    return customerService.updateCustomer(id, customer);
  }

  @DeleteMapping("/{id}")
  public String deleteCustomer(@PathVariable String id) {
    return customerService.deleteCustomer(id);
  }
}
