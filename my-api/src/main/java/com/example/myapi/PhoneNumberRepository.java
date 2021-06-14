package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    @Query("SELECT i FROM PhoneNumber i WHERE i.idClient = ?1")
    List<PhoneNumber> findPhoneNumbersByClientId(Long id);

    @Transactional
    @Modifying()
    @Query("DELETE FROM PhoneNumber i WHERE i.idClient=?1 AND i.id=?2")
    void deletePhoneFromBook(Long idClient, Long id);
}