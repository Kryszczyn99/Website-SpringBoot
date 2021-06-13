package com.example.myapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BasketRepositoryTests {

    @Autowired
    private BasketRepository repo;

    @Test
    public void testFindUserBasketById()
    {
        Long idWeLookFor = 27L;
        List<Basket> list = repo.findItemsByClientId(idWeLookFor);
        System.out.println(list);
    }
    @Test
    public void testFindItemFromBasketByIds()
    {
        Long idClient = 27L;
        Long idItem = 21L;
        Basket basket = repo.findItemByClientIdAndItemId(idItem,idClient);
        System.out.println(basket);
    }

    @Test
    public void testUpdateDatabaseBasket()
    {
        Long idClient = 27L;
        Long idItem = 21L;
        repo.updateCounterInDatabaseBasketUser(10,idClient,idItem);
    }
}
