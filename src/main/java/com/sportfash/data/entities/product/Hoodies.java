// File: com/sportfash/data/entities/product/Hoodie.java

package com.sportfash.data.entities.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("hoodie")
@Table(schema = "new_sale_platform", name = "hoodie")
public class Hoodies extends Product {
    private String size;
    private String color;
    private String composition;
    private String careInstructions;
}
