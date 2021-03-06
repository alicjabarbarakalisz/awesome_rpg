package com.umusic.awesome_rpg.model;

public class RPGCharacter {

    private int id;

    private String name;

    private Integer health = 1000;

    private Integer level = 1;

    private boolean alive = true;

    public RPGCharacter(String name, Integer health, Integer level, boolean alive) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.alive = alive;
    }

    public RPGCharacter(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
