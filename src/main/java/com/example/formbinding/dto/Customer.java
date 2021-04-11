package com.example.formbinding.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private  UUID CustomerId;
    private String email;
    private LocalDate regDate;
    private boolean active = true;
    private CustomerDetails details;

    public Customer() {
    }

    public Customer(String email, LocalDate regDate, boolean active, CustomerDetails details) {
        this.CustomerId = UUID.randomUUID();
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.details = details;
    }

    public UUID getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(UUID customerId) {
        CustomerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && Objects.equals(CustomerId, customer.CustomerId) && Objects.equals(email, customer.email) && Objects.equals(regDate, customer.regDate) && Objects.equals(details, customer.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerId, email, regDate, active, details);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                ", details=" + details +
                '}';
    }
}
