package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AddressesRepository extends JpaRepository<Addresses,Long> {

    @Query("SELECT i FROM Addresses i WHERE i.idClient = ?1")
    List<Addresses> findAddressesByClientId(Long client);
    @Query("SELECT i FROM Addresses i WHERE i.id=?1")
    Addresses findAddressesById(Long id);
    @Transactional
    @Modifying()
    @Query("DELETE FROM Addresses i WHERE i.idClient=?1 AND i.id=?2")
    void deleteAddressFromDatabase(Long idClient, Long id);

}
