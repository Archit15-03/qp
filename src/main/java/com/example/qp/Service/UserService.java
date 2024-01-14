package com.example.qp.Service;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.OrderResp;
import com.example.qp.Models.Orders;

import java.util.List;

public interface UserService {
   public List<Groceries> getAllItems();

  public OrderResp orderItems(List<Orders> orders);
}
