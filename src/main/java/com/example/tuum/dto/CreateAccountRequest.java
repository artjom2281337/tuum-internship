package com.example.tuum.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateAccountRequest {
    
    @NotNull(message = "Customer ID required")
    private Long customer_id;

    @NotNull(message = "Country required")
    private String country;

    @NotEmpty(message = "Currency required")
    private List<String> currencies;

    public CreateAccountRequest() {}
    public CreateAccountRequest(Long customer_id, String country, List<String> currencies) {
        this.customer_id = customer_id;
        this.country = country;
        this.currencies = currencies;
    }

    public Long getCustomer_id() {
        return customer_id;
    }
    public String getCountry() {
        return country;
    }
    public List<String> getCurrencies() {
        return currencies;
    }
    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

}
