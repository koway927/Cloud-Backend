package com.networking.demo.service.unused_service;


import com.networking.demo.entity.unused_entities.MenuItemEntity;
import com.networking.demo.repository.unused_repositories.MenuItemRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuItemService {


    private final MenuItemRepository menuItemRepository;


    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }


    public List<MenuItemEntity> getMenuItemsByRestaurantId(long restaurantId) {
        return menuItemRepository.getByRestaurantId(restaurantId);
    }


    public MenuItemEntity getMenuItemById(long id) {
        return menuItemRepository.findById(id).get();
    }
}
