// File: com/sportfash/data/entities/product/Backpack.java

package com.sportfash.data.entities.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("backpack")
@Table(schema = "new_sale_platform", name = "backpack")
public class Backpack extends Product {
    private String color;
    private String strapType;
    private String material;
    private String fastenings;
    private Integer pockets;
    private String careInstructions;
    private Boolean weatherproof;
}
