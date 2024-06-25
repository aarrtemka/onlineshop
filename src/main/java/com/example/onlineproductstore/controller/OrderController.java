package com.example.onlineproductstore.controller;

import com.example.onlineproductstore.dto.order.CompleteOrderDto;
import com.example.onlineproductstore.dto.order.OrderDto;
import com.example.onlineproductstore.dto.order.OrderItemDto;
import com.example.onlineproductstore.dto.order.OrderUpdateRequestDto;
import com.example.onlineproductstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order API", description = "Controller for managing orders in DB")
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "Complete an order",
            description = "Complete an order with the provided shipping address")
    @PostMapping
    public OrderDto placeOrder(@RequestBody @Valid CompleteOrderDto request) {
        return orderService.completeOrder(request);
    }

    @Operation(summary = "Get all user's orders",
            description = "Retrieve a list of user's order history")
    @GetMapping
    public List<OrderDto> getOrderHistory(Pageable pageable) {
        return orderService.getAll(pageable);
    }

    @Operation(summary = "Update order status",
            description = "Update the status of a specific order")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{orderId}")
    public OrderDto updateOrderStatus(@PathVariable Long orderId,
            @RequestBody @Valid OrderUpdateRequestDto request) {
        return orderService.updateStatus(orderId, request);
    }

    @Operation(summary = "Get all order items for a specific order",
            description = "Retrieve a list of all order items within a specific order")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{orderId}/items")
    public List<OrderItemDto> getAllOrderItems(@PathVariable Long orderId, Pageable pageable) {
        return orderService.getAllOrderItems(orderId, pageable);
    }

    @Operation(summary = "Get a specific order item within an order",
            description = "Retrieve details of a specific order item within a specific order")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{orderId}/items/{itemId}")
    public OrderItemDto getOrderItemById(@PathVariable Long orderId, @PathVariable Long itemId) {
        return orderService.getOrderItemById(orderId, itemId);
    }
}
