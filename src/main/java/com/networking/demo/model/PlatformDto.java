package com.networking.demo.model;

import com.networking.demo.entity.PlatformEntity;


import java.util.List;


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
