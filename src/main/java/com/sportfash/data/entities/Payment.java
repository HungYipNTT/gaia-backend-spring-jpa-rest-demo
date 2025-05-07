package com.sportfash.data.entities;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Payment {
    private String cardNo;
    private LocalDate expiryDate;
    private String cardHolderName;
}

