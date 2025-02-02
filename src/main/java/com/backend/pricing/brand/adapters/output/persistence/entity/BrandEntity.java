package com.backend.pricing.brand.adapters.output.persistence.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


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

}
