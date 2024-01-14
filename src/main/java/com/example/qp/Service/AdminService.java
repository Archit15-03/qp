package com.example.qp.Service;

import com.example.qp.Entity.Groceries;
import com.example.qp.Models.Item;
import com.example.qp.Models.Manage;

import java.util.List;

public interface AdminService {

    public boolean addItems(Groceries itemData);

    public List<Groceries> getAllItems();

    public boolean deleteItems(int id);

    public boolean updateItems(Item items);

    boolean manageItems(int id, Manage manage);
}
