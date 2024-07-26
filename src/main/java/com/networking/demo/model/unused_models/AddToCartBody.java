package com.networking.demo.model.unused_models;


import com.fasterxml.jackson.annotation.JsonProperty;


public record AddToCartBody(
        @JsonProperty("menu_id") Long menuId
) {
}
