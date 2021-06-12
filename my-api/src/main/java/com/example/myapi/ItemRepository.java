package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT i FROM Item i WHERE i.category = ?1")
    List<Item> findItemByCategory(String category);
}
