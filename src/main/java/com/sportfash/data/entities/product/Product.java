// File: com/sportfash/data/entities/product/Product.java

package com.sportfash.data.entities.product;

import com.sportfash.data.entities.Audit;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "new_sale_platform", name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "category", discriminatorType = DiscriminatorType.STRING)
public class Product extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String code;
    
    @Column(insertable = false, updatable = false)
    private String category;
    private String brand;
    private String productName;
    private String style;
    private String shortDescription;
    private Double unitPrice;
}
