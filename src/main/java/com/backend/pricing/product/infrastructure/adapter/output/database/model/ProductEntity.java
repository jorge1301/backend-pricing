package com.backend.pricing.product.infrastructure.adapter.output.database.model;


import com.backend.pricing.price.domain.model.Price;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
    @Id
    private Long id;

    private String name;

    private String description;

    @MappedCollection(idColumn = "product_id")
    private Set<Price> prices;
}
