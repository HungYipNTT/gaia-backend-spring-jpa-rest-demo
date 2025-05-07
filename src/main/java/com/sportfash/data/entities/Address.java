package com.sportfash.data.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String postCode;
}
