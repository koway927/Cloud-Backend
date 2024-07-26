package com.networking.demo.entity.unused_entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("restaurants")
public record PlatformEntity(
        @Id Long id,
        String name,
        String address,
        String phone,
        String imageUrl
) {
}
