package com.example.tuum.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateAccountRequest {
    
    @NotNull(message = "Customer ID required")
    private Long customerId;

    @NotNull(message = "Country required")
    private String country;

    @NotEmpty(message = "Currency required")
    private List<String> currencies;

    public CreateAccountRequest() {}
    public CreateAccountRequest(Long customerId, String country, List<String> currencies) {
        this.customerId = customerId;
        this.country = country;
        this.currencies = currencies;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public String getCountry() {
        return country;
    }
    public List<String> getCurrencies() {
        return currencies;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

}
