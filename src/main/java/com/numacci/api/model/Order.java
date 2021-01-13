package com.numacci.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;

public class Order {

  private String orderId;

  private int totalPrice;

  private List<OrderedProduct> orderedProducts;

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

  public List<OrderedProduct> getOrderedProducts() {
    return orderedProducts;
  }

  public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
    this.orderedProducts = orderedProducts;
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

  @Override
  public String toString() {
    return "Order{" +
        "orderId='" + orderId + '\'' +
        ", totalPrice=" + totalPrice +
        ", orderedProducts=" + orderedProducts +
        ", orderDate=" + orderDate +
        ", status='" + status + '\'' +
        '}';
  }
}
