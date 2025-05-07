// File: com/sportfash/data/entities/Customer.java

package com.sportfash.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "new_sale_platform", name = "customer")
public class Customer extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private LocalDate dateOfBirth;
    
    @Embedded
    private Payment payment;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1", column = @Column(name = "address_line_1")),
        @AttributeOverride(name = "addressLine2", column = @Column(name = "address_line_2")),
        @AttributeOverride(name = "postCode", column = @Column(name = "postcode"))
    })
    private Address address;

    // Additional attributes and methods
}
