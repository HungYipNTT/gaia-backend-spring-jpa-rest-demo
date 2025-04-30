// File: com/sportfash/data/entities/product/Trainer.java

package com.sportfash.data.entities.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("trainer")
@Table(schema = "new_sale_platform", name = "trainer")
public class Trainers extends Product {
    private String size;
    private String color;
}
