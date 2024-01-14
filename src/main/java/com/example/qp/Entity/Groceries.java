package com.example.qp.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(schema = "public",name = "Grocery")
@Entity
public class Groceries  {

//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grocery_sequence")
    @SequenceGenerator(name = "grocery_sequence", sequenceName = "grocery_sequence", allocationSize = 1)
    public int id;

    @EmbeddedId
    public GroceryKey groceryKey;

    @JsonProperty("quantity")
    public Integer quantity;
}
