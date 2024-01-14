package com.example.qp.Controller;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.Item;
import com.example.qp.Models.Manage;
import com.example.qp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/addItems")
    public boolean addItems(@RequestBody Groceries itemData){
       return adminService.addItems(itemData);
    }

    @GetMapping("/viewItems")
    public List<Groceries> viewItems(){

        return adminService.getAllItems();
    }

    @DeleteMapping("/removeItems/{id}")
    public boolean deletItems(@PathVariable("id") int id)
    {

        return adminService.deleteItems(id);
    }

//    @PatchMapping("/updateItems")
//    public boolean updateItems(@RequestBody Groceries items){
//        return adminService.updateItems(items);
//    }
    @PutMapping("/updateItems")
    public boolean updateItems(@RequestBody Item items)
    {
        return adminService.updateItems(items);
    }

    @PatchMapping("manageItems/id")
    public boolean manageItems(@PathVariable("id") int id, @RequestBody Manage manage){
        return adminService.manageItems(id,manage);
    }
}
