package com.example.qp.Repository;

import com.example.qp.Entity.Groceries;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroceryRepository extends JpaRepository<Groceries,Integer> {
    @Query("select a from Groceries a where a.groceryKey.groceryName=:itemName and a.groceryKey.price=:price")
    public Groceries findByGroceryKey(String itemName,Double price);

    @Modifying
    @Transactional
    @Query("delete from Groceries a where a.id=:id")
    void deleteItem(int id);

    @Query("select a from Groceries a where a.id=:id")
    public Optional<Groceries> findItem(int id);

    // public boolean addItems();
}
