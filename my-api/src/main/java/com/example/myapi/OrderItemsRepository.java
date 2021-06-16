package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {
    @Query("SELECT i FROM OrderItems i WHERE i.idOrder=?1")
    List<OrderItems> findOrderItemsByID(Long id);
}
