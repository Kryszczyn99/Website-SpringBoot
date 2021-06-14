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
public class AddressesRepositoryTests {
    @Autowired
    private AddressesRepository repo;

    @Test
    public void testFindItemByCat()
    {
        Long idClient = 27L;
        System.out.println(repo.findAddressesByClientId(idClient));
    }
}
