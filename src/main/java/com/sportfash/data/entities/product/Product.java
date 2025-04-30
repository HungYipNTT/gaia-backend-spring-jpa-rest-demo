// File: com/sportfash/data/entities/product/Product.java

package com.sportfash.data.entities.product;

import com.sportfash.data.entities.Audit;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "catagory", discriminatorType = DiscriminatorType.STRING)
@Table(schema = "new_sale_platform", name = "product")
public class Product extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String code;
    private String category;
    private String brand;
    private String productName;
    private String style;
    private String shortDescription;
    private Double unitPrice;
}
