package com.example.myapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository repo;
/*
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setAdmin(false);
        user.setFirstName("Krzysiek3");
        user.setLastName("Pijak2");
        user.setLogin("nowyLogin2");
        user.setPassword("Pam");
        repo.save(user);

    }

 */
    @Test
    public void testFindItemByCat()
    {
        String cat = "Gaming";
        List<Item> list = repo.findItemByCategory(cat);
        System.out.println(list);
        assertThat(list).isNotNull();
    }
}