package com.numacci.api.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.numacci.api.service.impl.CustomerServiceImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerControllerTest {

  @Mock
  private CustomerServiceImpl customerService;

  @InjectMocks
  private CustomerController controller;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @DisplayName("Check that controller dispatches request properly.")
  @Test
  public void testGetCustomerByConditions() {
    // Test the case of String gender and postCode.
    testGetCustomerByGenderAndPostCode();
    // Initialize request parameters and mock.
    init();

    // Test the case of LocalDate from and to.
    testGetCustomerRecentlyOrdered();
    // Initialize request parameters and mock.
    init();

    // Test the case of Integer minPrice.
    testGetCustomerOrderedHighPrice();
  }

  private void testGetCustomerByGenderAndPostCode() {
    Map<String, String> requestParams = new HashMap<>();
    String gender = "M";
    String postCode = "999-9999";
    requestParams.put("gender", gender);
    requestParams.put("postCode", postCode);

    controller.getCustomerByConditions(requestParams);
    verify(customerService, times(1)).getCustomerByGenderAndPostCode(gender, postCode);
    verify(customerService, times(0))
        .getCustomerRecentlyOrdered(any(LocalDate.class), any(LocalDate.class));
    verify(customerService, times(0)).getCustomerOrderedHighPrice(anyInt());
  }

  private void testGetCustomerRecentlyOrdered() {
    Map<String, String> requestParams = new HashMap<>();
    String fromDate = "2020-01-01";
    String toDate = "2021-01-01";
    requestParams.put("from", fromDate);
    requestParams.put("to", toDate);

    LocalDate from = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate to = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    controller.getCustomerByConditions(requestParams);
    verify(customerService, times(0))
        .getCustomerByGenderAndPostCode(any(String.class), any(String.class));
    verify(customerService, times(1)).getCustomerRecentlyOrdered(from, to);
    verify(customerService, times(0)).getCustomerOrderedHighPrice(anyInt());
  }

  private void testGetCustomerOrderedHighPrice() {
    Map<String, String> requestParams = new HashMap<>();
    String minPriceStr = "4000";
    requestParams.put("minPrice", minPriceStr);

    int minPrice = Integer.parseInt(minPriceStr);
    controller.getCustomerByConditions(requestParams);
    verify(customerService, times(0))
        .getCustomerByGenderAndPostCode(any(String.class), any(String.class));
    verify(customerService, times(0))
        .getCustomerRecentlyOrdered(any(LocalDate.class), any(LocalDate.class));
    verify(customerService, times(1)).getCustomerOrderedHighPrice(minPrice);
  }

  private void init() {
    clearInvocations(customerService);
  }
}
