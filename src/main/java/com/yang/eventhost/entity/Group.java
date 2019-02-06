package com.yang.eventhost.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="`group`")
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="`name`")
    private String name;

    @OneToMany(fetch= FetchType.EAGER, mappedBy="group",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Account> mates;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Account> getMates() {
        return mates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMates(List<Account> mates) {
        this.mates = mates;
    }

    public void addMate(Account account) {
        if (mates == null) {
            mates = new ArrayList<>();
        }
        mates.add(account);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }

}
