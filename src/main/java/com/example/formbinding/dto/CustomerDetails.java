package com.example.formbinding.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class CustomerDetails {
    private UUID detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;

    public CustomerDetails() {
        detailsId = UUID.randomUUID();

    }

    public CustomerDetails(String street, String zipCode, String city, String homePhone, String cellPhone) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
    }


}

