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
        int idWeLookFor = 27;
        List<Basket> list = repo.findItemsByClientId(idWeLookFor);
        System.out.println(list);
    }
}
