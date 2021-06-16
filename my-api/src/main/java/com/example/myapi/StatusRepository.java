package com.example.myapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StatusRepository extends JpaRepository<Status,Long> {
    @Query("SELECt i FROM Status i ")
    List<Status> getAllStatuses();
}
