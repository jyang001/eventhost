package com.yang.eventhost.repository;

import com.yang.eventhost.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findAccountByUsername(String username);

}