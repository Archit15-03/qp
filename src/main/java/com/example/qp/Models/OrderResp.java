package com.example.qp.Models;

import lombok.Data;

import java.util.List;

@Data
public class OrderResp {
    public Double total;
    public List<Item> itemList;
}
