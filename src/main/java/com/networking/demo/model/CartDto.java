package com.networking.demo.model;


import com.networking.demo.entity.CartEntity;

import java.util.List;

public record CartDto(
        Long id,
        Double totalPrice,
        List<OrderItemDto> orderItems
) {
    public CartDto(CartEntity entity, List<OrderItemDto> orderItems) {
        this(
                entity.id(),
                entity.totalPrice(),
                orderItems
        );
    }
}
