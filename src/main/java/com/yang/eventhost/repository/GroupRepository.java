package com.yang.eventhost.repository;

import com.yang.eventhost.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends JpaRepository<Group, Integer> {

}
