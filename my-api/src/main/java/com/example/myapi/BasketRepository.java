package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    @Query("SELECT i FROM Basket i WHERE i.idClient = ?1")
    List<Basket> findItemsByClientId(Long client);
}
