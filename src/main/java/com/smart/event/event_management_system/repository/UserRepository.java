package com.smart.event.event_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.event.event_management_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll(); 
}
