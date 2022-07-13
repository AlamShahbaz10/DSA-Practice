package com.coding.orderservice.service;

import com.coding.orderservice.common.Payment;
import com.coding.orderservice.common.TransactionRequest;
import com.coding.orderservice.common.TransactionResponse;
import com.coding.orderservice.entity.Order;
import com.coding.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/makePayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("Success") ? "Payment processing complete!" : "Error in payment processing!";

        repo.save(order);

        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }
}
