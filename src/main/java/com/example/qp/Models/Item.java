package com.example.qp.Models;


import lombok.Data;

@Data
public class Item {
    public int id;
    public String itemName;
    public Double itemPrice;
    public Integer quantity;
    public String message;
}
