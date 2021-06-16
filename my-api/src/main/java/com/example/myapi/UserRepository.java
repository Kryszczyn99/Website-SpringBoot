package com.example.myapi;

import com.example.myapi.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    User findUserByLogin(String login);
    @Query("SELECT u FROM User u WHERE u.id=?1")
    User findUserById(Long id);
}
