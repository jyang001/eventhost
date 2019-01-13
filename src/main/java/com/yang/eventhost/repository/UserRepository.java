package com.yang.eventhost.repository;

import com.yang.eventhost.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
