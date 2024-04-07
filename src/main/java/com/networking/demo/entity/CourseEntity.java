package com.networking.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("carts")
public record CourseEntity(
        @Id Long id,
        Long customerId,
        Double totalPrice
) {
}
