package com.cpe.llop.chaduc.buchaille.medard.asi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {

    @Id
    private long id;

    private String name;
    private int health;
    private int attack;
    private int defense;

    public Card() {
    }

    public Card(String name, int health, int attack, int defense) {
        setName(name);
        setHealth(health);
        setAttack(attack);
        setDefense(defense);
    }

    private void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
