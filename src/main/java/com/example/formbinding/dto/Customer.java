package com.example.formbinding.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


@Data
public class Customer {
    private UUID customerId;
    private String email;
    private LocalDate regDate;
    private boolean active;
    private CustomerDetails details;

    public Customer() {
        customerId = UUID.randomUUID();
        regDate = LocalDate.now();
        active = true;
    }




}
