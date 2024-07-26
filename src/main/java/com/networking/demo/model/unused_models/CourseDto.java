package com.networking.demo.model.unused_models;


import java.util.List;

import com.networking.demo.entity.unused_entities.CourseEntity;

public record CourseDto(
        Long id,
        Double totalPrice,
        List<OrderItemDto> orderItems
) {
    public CourseDto(CourseEntity entity, List<OrderItemDto> orderItems) {
        this(
                entity.id(),
                entity.totalPrice(),
                orderItems
        );
    }
}
