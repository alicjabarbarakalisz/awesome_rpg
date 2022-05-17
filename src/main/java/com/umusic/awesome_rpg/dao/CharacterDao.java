package com.umusic.awesome_rpg.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createCharacter(String name, Integer health, boolean alive, Integer level){
        jdbcTemplate.update(
                "INSERT INTO rpg.rpg_character (name, health, alive, level) VALUES (?, ?)",
                name, health, alive, level
        );
    }

}
