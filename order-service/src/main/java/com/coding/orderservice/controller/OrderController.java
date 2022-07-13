package com.coding.orderservice.controller;

import com.coding.orderservice.common.Payment;
import com.coding.orderservice.common.TransactionRequest;
import com.coding.orderservice.common.TransactionResponse;
import com.coding.orderservice.entity.Order;
import com.coding.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return service.saveOrder(request);
    }
}
