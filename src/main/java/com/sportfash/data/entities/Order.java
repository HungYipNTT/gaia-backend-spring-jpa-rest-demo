// File: com/sportfash/data/entities/Order.java

package com.sportfash.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "new_sale_platform", name = "order")
public class Order extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    private String promotionCode;
    private Double discount;
    private Double vat;
    private Double totalAmount;
    private String paymentReference;
    private String shippingAddress;
}
