package com.networking.demo.controller.unused_controllers;


import com.networking.demo.entity.unused_entities.MenuItemEntity;
import com.networking.demo.model.unused_models.PlatformDto;
import com.networking.demo.service.unused_service.MenuItemService;
import com.networking.demo.service.unused_service.PlatformService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MenuController {


    private final PlatformService platformService;
    private final MenuItemService menuItemService;


    public MenuController(PlatformService platformService, MenuItemService menuItemService) {
        this.platformService = platformService;
        this.menuItemService = menuItemService;
    }


    @GetMapping("/restaurant/{restaurantId}/menu")
    public List<MenuItemEntity> getMenuByRestaurant(@PathVariable("restaurantId")  long restaurantId) {
        return menuItemService.getMenuItemsByRestaurantId(restaurantId);
    }


    @GetMapping("/restaurants/menu")
    public List<PlatformDto> getMenuForAllRestaurants() {
        return platformService.getRestaurants();
    }
}
