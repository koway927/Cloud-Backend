package com.networking.demo.model;


import com.networking.demo.entity.CourseEntity;

import java.util.List;

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
