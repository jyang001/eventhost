package com.yang.eventhost.repository;

import com.yang.eventhost.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * used to save data from the 'Account' JDO to 'account' in SQL
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * finds the row in the database with the 'username' and returns as an 'Account' object
     * @param username: username of the Account
     * @return Account object with the username
     */
    public Account findAccountByUsername(String username);

}