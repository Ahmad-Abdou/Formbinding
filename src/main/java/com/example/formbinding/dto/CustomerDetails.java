package com.example.formbinding.dto;

import java.util.Objects;
import java.util.UUID;

public class CustomerDetails {
    private UUID detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;

    public CustomerDetails() {
    }

    public CustomerDetails(String street, String zipCode, String city, String homePhone, String cellPhone) {
        this.detailsId = UUID.randomUUID();
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
    }

    public UUID getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(UUID detailsId) {
        this.detailsId = detailsId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(detailsId, that.detailsId) && Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(homePhone, that.homePhone) && Objects.equals(cellPhone, that.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, street, zipCode, city, homePhone, cellPhone);
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "detailsId='" + detailsId + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}

