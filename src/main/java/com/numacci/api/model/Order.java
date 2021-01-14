package com.numacci.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;

public class Order {
  private String orderId;
  private int totalPrice;
  private List<Product> orderedProducts;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate orderDate;
  private String status;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<Product> getOrderedProducts() {
    return orderedProducts;
  }

  public void setOrderedProducts(List<Product> products) {
    this.orderedProducts = products;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
