package com.networking.demo.repository.unused_repositories;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.networking.demo.entity.unused_entities.OrderItemEntity;

import java.util.List;


public interface OrderItemRepository extends ListCrudRepository<OrderItemEntity, Long> {


    List<OrderItemEntity> getAllByCartId(Long cartId);


    OrderItemEntity findByCartIdAndMenuItemId(Long cartId, Long menuItemId);


    @Modifying
    @Query("DELETE FROM order_items WHERE cart_id = :cartId")
    void deleteByCartId(Long cartId);
}
