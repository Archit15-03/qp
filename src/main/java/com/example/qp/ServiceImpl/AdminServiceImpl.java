package com.example.qp.ServiceImpl;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.Item;
import com.example.qp.Models.Manage;
import com.example.qp.Repository.GroceryRepository;
import com.example.qp.Service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    GroceryRepository adminRepo;

    @Override
    public boolean addItems(Groceries itemData) {
        if(!("".equalsIgnoreCase(itemData.getGroceryKey().getGroceryName()) || null == itemData.getGroceryKey().getPrice())){
                log.info("items here {}",itemData);
                adminRepo.save(itemData);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Groceries> getAllItems() {
        List<Groceries> allItems = adminRepo.findAll();
        return allItems;
    }

    @Override
    public boolean deleteItems(int id) {
        Groceries checkItem = adminRepo.findItem(id)
                .orElseThrow(()->new NoSuchElementException("Please enter correct id"));
        adminRepo.deleteItem(id) ;
        return true;
    }

    @Override
    public boolean updateItems(Item items) {
        Optional<Groceries> repoData = adminRepo.findItem(items.getId());
        Groceries data = new Groceries();
        if(repoData.isPresent()){
            data = repoData.get();
        }else{
            throw new NoSuchElementException("No such product exists");
        }
        if(null != items.getItemName() && !("".equalsIgnoreCase(items.getItemName()))){
            data.getGroceryKey().setGroceryName(items.getItemName());
        }
        if(null != items.getItemPrice()){
            data.getGroceryKey().setPrice(items.getItemPrice());
        }
        if(null != items.getQuantity()){
            data.setQuantity(items.getQuantity());
        }
        adminRepo.save(data);
        return true;
    }

    @Override
    public boolean manageItems(int id, Manage manage) {
        Optional<Groceries> repoData = adminRepo.findById(id);
        Groceries data = new Groceries();
        if(repoData.isPresent()){
            data = repoData.get();
        }
        if(null != manage.getQuantity()){
            data.setQuantity(manage.getQuantity());
        }
        adminRepo.save(data);
        return true;
    }
}
