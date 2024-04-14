package com.networking.demo.service;


import com.networking.demo.entity.CourseEntity;
import com.networking.demo.entity.MenuItemEntity;
import com.networking.demo.entity.OrderItemEntity;
import com.networking.demo.model.CourseDto;
import com.networking.demo.model.OrderItemDto;
import com.networking.demo.repository.CourseRepository;
import com.networking.demo.repository.MenuItemRepository;
import com.networking.demo.repository.OrderItemRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class CourseService {


    private final CourseRepository courseRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;


    public CourseService(CourseRepository courseRepository, MenuItemRepository menuItemRepository, OrderItemRepository orderItemRepository) {
        this.courseRepository = courseRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @CacheEvict(cacheNames = "cart", key = "#customerId")
    @Transactional
    public void addMenuItemToCart(long customerId, long menuItemId) {
        CourseEntity cart = courseRepository.getByCustomerId(customerId);
        MenuItemEntity menuItem = menuItemRepository.findById(menuItemId).get();
        OrderItemEntity orderItem = orderItemRepository.findByCartIdAndMenuItemId(cart.id(), menuItem.id());
        Long orderItemId;
        int quantity;


        if (orderItem == null) {
            orderItemId = null;
            quantity = 1;
        } else {
            orderItemId = orderItem.id();
            quantity = orderItem.quantity() + 1;
        }
        OrderItemEntity newOrderItem = new OrderItemEntity(orderItemId, menuItemId, cart.id(), menuItem.price(), quantity);
        orderItemRepository.save(newOrderItem);
        courseRepository.updateTotalPrice(cart.id(), cart.totalPrice() + menuItem.price());
    }

    @Cacheable("cart")
    public CourseDto getCart(Long customerId) {
        CourseEntity cart = courseRepository.getByCustomerId(customerId);
        List<OrderItemEntity> orderItems = orderItemRepository.getAllByCartId(cart.id());
        List<OrderItemDto> orderItemDtos = getOrderItemDtos(orderItems);
        return new CourseDto(cart, orderItemDtos);
    }
    @CacheEvict(cacheNames = "cart")
    @Transactional
    public void clearCart(Long customerId) {
        CourseEntity courseEntity = courseRepository.getByCustomerId(customerId);
        orderItemRepository.deleteByCartId(courseEntity.id());
        courseRepository.updateTotalPrice(courseEntity.id(), 0.0);
    }


    private List<OrderItemDto> getOrderItemDtos(List<OrderItemEntity> orderItems) {
        Set<Long> menuItemIds = new HashSet<>();
        for (OrderItemEntity orderItem : orderItems) {
            menuItemIds.add(orderItem.menuItemId());
        }
        List<MenuItemEntity> menuItems = menuItemRepository.findAllById(menuItemIds);
        Map<Long, MenuItemEntity> menuItemMap = new HashMap<>();
        for (MenuItemEntity menuItem : menuItems) {
            menuItemMap.put(menuItem.id(), menuItem);
        }
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for (OrderItemEntity orderItem : orderItems) {
            MenuItemEntity menuItem = menuItemMap.get(orderItem.menuItemId());
            OrderItemDto orderItemDto = new OrderItemDto(orderItem, menuItem);
            orderItemDtos.add(orderItemDto);
        }


//        // Stream version:
//        Set<Long> menuItemIds = orderItems.stream()
//                .map(OrderItemEntity::menuItemId)
//                .collect(Collectors.toSet());
//
//        List<MenuItemEntity> menuItems = menuItemRepository.findAllById(menuItemIds);
//
//        Map<Long, MenuItemEntity> menuItemMap = menuItems.stream()
//                .collect(Collectors.toMap(MenuItemEntity::id, menuItem -> menuItem));
//
//        List<OrderItemDto> orderItemDtos = orderItems.stream()
//                .map(orderItem -> {
//                    MenuItemEntity menuItem = menuItemMap.get(orderItem.menuItemId());
//                    return new OrderItemDto(orderItem, menuItem);
//                })
//                .toList();
        return orderItemDtos;
    }


}
