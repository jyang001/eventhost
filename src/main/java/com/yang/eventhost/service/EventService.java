package com.yang.eventhost.service;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.entity.Event;
import com.yang.eventhost.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    private ConfigurableApplicationContext ctx;

    private char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();

    private String createRandomCode(int codeLength){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        String output = stringBuilder.toString();
        return output;
    }

    private String generateCode() {
        for(int i = 5; i < chars.length; i++) {
            String code = createRandomCode(i);
            if(eventRepository.findByInvitationCode(code) == null) {
                System.out.println("code is:" + code);
                return code;
            }
        }
        System.out.println("All INVITATION CODES N/A SHUTTING DOWN APPLICATION");
        ctx.close();
        return null;
    }

    public void createEvent(Event event, Account currentAccount) {
        event.addAccount(currentAccount);
        currentAccount.addEvent(event);
        String invitationCode = generateCode();
        event.setInvitationCode(invitationCode);
        eventRepository.save(event);
        accountService.updateAccountByEvent(currentAccount);
    }



}
