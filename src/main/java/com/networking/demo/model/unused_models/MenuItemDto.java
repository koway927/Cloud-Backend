package com.networking.demo.model.unused_models;


import com.networking.demo.entity.unused_entities.MenuItemEntity;

public record MenuItemDto(
        Long id,
        String name,
        String description,
        Double price,
        String imageUrl
) {
    public MenuItemDto(MenuItemEntity entity) {
        this(
                entity.id(),
                entity.name(),
                entity.description(),
                entity.price(),
                entity.imageUrl()
        );
    }
}
