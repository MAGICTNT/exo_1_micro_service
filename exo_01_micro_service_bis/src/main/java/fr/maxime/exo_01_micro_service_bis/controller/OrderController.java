package fr.maxime.exo_01_micro_service_bis.controller;

import fr.maxime.exo_01_micro_service_bis.entity.Order;
import fr.maxime.exo_01_micro_service_bis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}")
    public ResponseEntity<Order>getByIdUser(@PathVariable("userId") long userId){
        return ResponseEntity.ok(orderService.getByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Order> create (@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
    }
}
