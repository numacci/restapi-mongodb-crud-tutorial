package com.numacci.api.service;

import com.numacci.api.model.Customer;
import com.numacci.api.model.Order;
import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

  /**
   * Get a customer with the same customer id as provided.
   *
   * @param customerId identity of the customer
   * @return customer who has the same is as provided
   */
  Customer getCustomerById(String customerId);

  /**
   * Get customers that match the provided gender and postcode.
   *
   * @param gender gender of the customer
   * @param postCode postcode of the customer
   * @return customers who have the same gender and postcode
   */
  List<Customer> getCustomerByGenderAndPostCode(String gender, String postCode);

  /**
   * Get customers who have ordered between two provided dates.
   *
   * @param from the earliest date in range "between"
   * @param to the newest date in range "between"
   * @return customers who have ordered between from and to
   */
  List<Customer> getCustomerRecentlyOrdered(LocalDate from, LocalDate to);

  /**
   * Get customers who ordered expensive products.
   *
   * @param minPrice minimum price of total price of an order
   * @return customers whose total price is greater than minPrice
   */
  List<Customer> getCustomerOrderedHighPrice(int minPrice);

  /**
   * Create a new customer.
   *
   * @param customer new customer
   * @return customer newly created
   */
  Customer createCustomer(Customer customer);

  /**
   * Create a new order.
   *
   * @param id identity of the customer
   * @param order new order
   * @return customer newly ordered
   */
  Customer createOrder(String id, Order order);

  /**
   * Update customer information.
   *
   * @param id identity of the customer
   * @param customer target customer
   * @return updated customer
   */
  Customer updateCustomer(String id, Customer customer);

  /**
   * Delete a customer with the same id as provided.
   *
   * @param id identity of the customer
   * @return deleted customer
   */
  Customer deleteCustomer(String id);
}
