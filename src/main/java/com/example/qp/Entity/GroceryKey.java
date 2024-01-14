package com.example.qp.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class GroceryKey implements Serializable {
    @JsonProperty("grocery_name")
    public String groceryName;
    @JsonProperty("price")
    public Double price;
}
