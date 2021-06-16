package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    @Query("SELECT i FROM Orders i")
    List<Orders> getOrders();
    @Query("SELECT i FROM Orders i WHERE i.id=?1")
    Orders getOrderByID(Long id);

    @Transactional
    @Modifying()
    @Query("UPDATE Orders i SET i.expectedDeliveryDate=?2 WHERE i.id=?1")
    void updateOrdersByIDForNewDate(Long id, Date date);
}
