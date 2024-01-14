package com.example.qp.ServiceImpl;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.Item;
import com.example.qp.Models.OrderResp;
import com.example.qp.Models.Orders;
import com.example.qp.Repository.GroceryRepository;
import com.example.qp.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    GroceryRepository userRepo;
    @Override
    public List<Groceries> getAllItems() {
        List<Groceries> allItems = userRepo.findAll();
        return allItems;
    }

    @Override
    public OrderResp orderItems(List<Orders> orders) {
        Double total =0.0;
        Item item = new Item();
        OrderResp resp= new OrderResp();
        List<Item> itemList = new ArrayList<>();
        for(Orders newOrder:orders) {
            if (null != newOrder.getItemName() && null != newOrder.getPrice()) {
            Groceries data = userRepo.findByGroceryKey(newOrder.getItemName(), newOrder.getPrice());
            log.info("Database data {} ", data);
            if(null == data){
                throw new IllegalArgumentException("Data not found in DB");
            }
            if (newOrder.getQuantity() > data.getQuantity()) {
                item.setMessage("Not sufficient material available, Please reduce quantity");
            }
            total = total + data.getGroceryKey().getPrice();
            item.setItemName(data.getGroceryKey().getGroceryName());
            item.setItemPrice(data.getGroceryKey().getPrice());
            item.setQuantity(data.getQuantity() - newOrder.getQuantity());
            itemList.add(item);
        }else{
                throw new IllegalArgumentException("Please enter valid values");
            }
        }
        resp.setTotal(total);
        resp.setItemList(itemList);
        return resp;
    }
}
