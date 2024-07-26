package com.networking.demo.model.unused_models;

import java.util.List;

import com.networking.demo.entity.unused_entities.PlatformEntity;


public record PlatformDto(
        Long id,
        String name,
        String address,
        String phone,
        String imageUrl,
        List<MenuItemDto> menuItems
) {
    public PlatformDto(PlatformEntity entity, List<MenuItemDto> menuItems) {
        this(entity.id(), entity.name(), entity.address(), entity.phone(), entity.imageUrl(), menuItems);
    }
}
