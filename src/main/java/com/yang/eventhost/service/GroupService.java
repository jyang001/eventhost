package com.yang.eventhost.service;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.entity.Group;
import com.yang.eventhost.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    AccountService accountService;

    public void createGroup(Group group, Account currentAccount) {
        currentAccount.setGroup(group);
        group.addMate(currentAccount);
        groupRepository.save(group);
        accountService.updateAccount(currentAccount);
    }

}
