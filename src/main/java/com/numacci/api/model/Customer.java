package com.numacci.api.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Customer {

  @Id
  private String id;

  private String customerId;

  private String customerName;

  private int age;

  private String gender;

  private String postCode;

  private String address;

  private List<Order> orders;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id='" + id + '\'' +
        ", customerId='" + customerId + '\'' +
        ", customerName='" + customerName + '\'' +
        ", age=" + age +
        ", postCode='" + postCode + '\'' +
        ", address='" + address + '\'' +
        ", orders=" + orders +
        '}';
  }
}
