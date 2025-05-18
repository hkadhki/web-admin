package org.writer.webadmin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ProductEntity product;

    @Column(columnDefinition = "INTEGER CHECK (quantity >= 0)")
    @PositiveOrZero
    private Integer quantity;

    @Column(columnDefinition = "numeric CHECK (price_at_purchase > 0)")
    @Positive
    private BigDecimal priceAtPurchase;

    @ManyToOne
    private OrderEntity order;
}
