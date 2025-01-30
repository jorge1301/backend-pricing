package com.backend.pricing.brand.infrastructure.adapter.output.database.model;


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
@Table(name = "brand")
public class BrandEntity {

    @Id
    private Long id;

    private String name;

    @MappedCollection(idColumn = "brand_id")
    private Set<Price> prices;

}
