package com.yang.eventhost.repository;

import com.yang.eventhost.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository  extends JpaRepository<Event, Integer> {

    public Event findByInvitationCode(String invitationCode);
}
