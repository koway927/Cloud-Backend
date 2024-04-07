package com.networking.demo.controller;


import com.networking.demo.entity.MenuItemEntity;
import com.networking.demo.model.PlatformDto;
import com.networking.demo.service.MenuItemService;
import com.networking.demo.service.PlatformService;
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
