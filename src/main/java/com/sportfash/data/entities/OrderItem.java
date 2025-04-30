// File: com/sportfash/data/entities/OrderItem.java

package com.sportfash.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import com.sportfash.data.entities.product.Product;

@Data
@Entity
@Table(schema = "new_sale_platform", name = "order_item")
public class OrderItem extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "order_number")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String shortDescription;
    private Integer qty;
    private Double unitPrice;
    private Double amount;
}
