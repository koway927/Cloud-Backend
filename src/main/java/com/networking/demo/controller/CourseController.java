package com.networking.demo.controller;


import com.networking.demo.entity.LearnerEntity;
import com.networking.demo.model.unused_models.AddToCartBody;
import com.networking.demo.model.unused_models.CourseDto;
import com.networking.demo.service.LearnerService;
import com.networking.demo.service.unused_service.CourseService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {


    private final CourseService courseService;
    private final LearnerService learnerService;


    public CourseController(
            CourseService courseService,
            LearnerService learnerService) {
        this.courseService = courseService;
        this.learnerService = learnerService;
    }


    @GetMapping("/cart")
    public CourseDto getCart(@AuthenticationPrincipal User user) {
        LearnerEntity customer = learnerService.getCustomerByEmail(user.getUsername());
        return courseService.getCart(customer.id());
    }


    @PostMapping("/cart")
    public void addToCart(@AuthenticationPrincipal User user, @RequestBody AddToCartBody body) {
        LearnerEntity customer = learnerService.getCustomerByEmail(user.getUsername());
        courseService.addMenuItemToCart(customer.id(), body.menuId());
    }


    @PostMapping("/cart/checkout")
    public void checkout(@AuthenticationPrincipal User user) {
        LearnerEntity customer = learnerService.getCustomerByEmail(user.getUsername());
        courseService.clearCart(customer.id());
    }
}
