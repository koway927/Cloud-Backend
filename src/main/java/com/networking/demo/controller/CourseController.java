package com.networking.demo.controller;


import com.networking.demo.entity.CustomerEntity;
import com.networking.demo.model.AddToCartBody;
import com.networking.demo.model.CourseDto;
import com.networking.demo.service.CourseService;
import com.networking.demo.service.CustomerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {


    private final CourseService courseService;
    private final CustomerService customerService;


    public CourseController(
            CourseService courseService,
            CustomerService customerService) {
        this.courseService = courseService;
        this.customerService = customerService;
    }


    @GetMapping("/cart")
    public CourseDto getCart(@AuthenticationPrincipal User user) {
        CustomerEntity customer = customerService.getCustomerByEmail(user.getUsername());
        return courseService.getCart(customer.id());
    }


    @PostMapping("/cart")
    public void addToCart(@AuthenticationPrincipal User user, @RequestBody AddToCartBody body) {
        CustomerEntity customer = customerService.getCustomerByEmail(user.getUsername());
        courseService.addMenuItemToCart(customer.id(), body.menuId());
    }


    @PostMapping("/cart/checkout")
    public void checkout(@AuthenticationPrincipal User user) {
        CustomerEntity customer = customerService.getCustomerByEmail(user.getUsername());
        courseService.clearCart(customer.id());
    }
}
