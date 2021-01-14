package com.numacci.api.repository;

import com.numacci.api.model.Customer;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  /**
   * Retrieve a customer document with the same customerId as provided.
   *
   * @param customerId identity of customer
   * @return customer document which has the same customerId as provided
   */
  Customer findByCustomerId(String customerId);

  /**
   * Retrieve customer documents that match the provided gender and postcode.
   * We can use "And" keyword for method name to describe the "and" condition.
   * Please refer to the following link for more information on naming conventions of spring data mongodb.
   *   https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
   *
   * @param gender gender of the customer
   * @param postCode postcode of the customer
   * @return customer documents which have the same gender and postcode
   */
  List<Customer> findByGenderAndPostCode(String gender, String postCode);

  /**
   * Retrieve customers who have ordered between two provided dates.
   * Conditions can also be applied to fields inside nested objects by simply connecting field names.
   * We can also use "Between" keyword for method name.
   *
   * @param from the earliest date in range "between"
   * @param to the newest date in range "between"
   * @return customers who have ordered between the date
   */
  List<Customer> findByOrdersOrderDateBetween(LocalDate from, LocalDate to);

  /**
   * Retrieve customers who have the order that totalPrice is greater than the provided value.
   *
   * @param minPrice minimum price of totalPrice
   * @return customers who have the order that totalPrice is greater than minPrice
   */
  @Query("{ 'orders.totalPrice' : { $gt : ?0 } }")
  List<Customer> findByTotalPriceGt(int minPrice);

  /**
   * Delete a customer document with the same customerId as provided.
   *
   * @param customerId identity of customer
   * @return deleted object
   */
  Customer deleteByCustomerId(String customerId);
}
