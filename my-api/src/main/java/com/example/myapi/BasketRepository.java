package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface BasketRepository extends JpaRepository<Basket,Long> {

    @Query("SELECT i FROM Basket i WHERE i.idClient = ?1")
    List<Basket> findItemsByClientId(Long client);
    @Query("SELECT i FROM Basket i WHERE i.idItem = ?1 AND i.idClient = ?2")
    Basket findItemByClientIdAndItemId(Long idItem, Long idClient);
    @Transactional
    @Modifying()
    @Query("UPDATE Basket i SET i.itemCountered=?1 WHERE i.idClient=?2 AND i.idItem=?3")
    void updateCounterInDatabaseBasketUser(int newCounter, Long idClient, Long idItem);

    @Transactional
    @Modifying()
    @Query("DELETE FROM Basket i WHERE i.idClient=?1")
    void deleteEverythingFromUserBasket(Long idClient);
}
