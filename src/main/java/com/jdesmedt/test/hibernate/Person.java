package com.jdesmedt.test.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorne on 27/04/2018.
 */
@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany (cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Weapon> weapons = new ArrayList<Weapon>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return String.format("%s[%d, %s, %s]", getClass().getSimpleName(), id, name, weapons);
    }
}
