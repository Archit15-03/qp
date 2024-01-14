package com.example.qp.Controller;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.OrderResp;
import com.example.qp.Models.Orders;
import com.example.qp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/viewItems")
    public List<Groceries> viewItems(){
        return userService.getAllItems();
    }

    @PostMapping("/orderItems")
    public OrderResp orderItems(@RequestBody List<Orders> orders){
        return userService.orderItems(orders);
    }
}
