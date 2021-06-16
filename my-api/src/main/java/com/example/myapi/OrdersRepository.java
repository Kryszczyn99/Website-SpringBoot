package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    @Query("SELECT i FROM Orders i")
    List<Orders> getOrders();
}
