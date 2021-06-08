package com.example.myapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;
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
//    @Test
//    public void testFindUserByLogin()
//    {
//        String login = "test";
//        User user = repo.findUserByLogin(login);
//        assertThat(user).isNotNull();
//    }
}
