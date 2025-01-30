package com.backend.pricing.price.infrastructure.adapter.output.database.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "price")
public class PriceEntity {

    @Id
    private Long id;

    @Column("brand_id")
    private Long brandId;

    @Column("product_id")
    private Long productId;

    @Column("start_date")
    private LocalDateTime startDate;

    @Column("end_date")
    private LocalDateTime endDate;

    @Column("price_list")
    private Long priceList;

    @Column("priority")
    private Integer priority;

    @Column("price")
    private BigDecimal price;

    @Column("currency")
    private String currency;
}
