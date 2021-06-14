package com.example.myapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PhoneNumberRepositoryTests {

    @Autowired
    private PhoneNumberRepository repo;
    @Test
    public void testFindNumberById()
    {
        Long id = 27L;
        List<PhoneNumber> item = repo.findPhoneNumbersByClientId(id);
        for(PhoneNumber ph:item)
        {
            System.out.println(ph);
        }
    }
}
