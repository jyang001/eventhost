package com.yang.eventhost.service;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveAccount(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public void updateAccountByEvent(Account account) {
        Account myAccount = accountRepository.getOne(account.getId());
        myAccount.setEvent(account.getEvent());
        accountRepository.save(myAccount);
    }

}
