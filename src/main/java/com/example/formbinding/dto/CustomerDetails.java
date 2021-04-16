package com.example.formbinding.dto;

import lombok.Data;


@Data
public class CustomerDetails {
    private String detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;

    public CustomerDetails() {
    }

}

