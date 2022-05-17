package com.umusic.awesome_rpg.dao;

import com.umusic.awesome_rpg.model.RPGCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createCharacter(String name, Integer health, boolean alive, Integer level){
        jdbcTemplate.update("INSERT INTO rpg.rpg_character (name, health, alive, level) VALUES (?, ?, ?, ?)",
                name, health, alive, level
        );
    }

    public RPGCharacter getCharacter(String name){
        return jdbcTemplate.queryForObject("SELECT * FROM rpg.rpg_character WHERE name = ?", new Object[]{name}, (rs, rowNum) ->
                new RPGCharacter(
                        rs.getString("name"),
                        rs.getInt("health"),
                        rs.getInt("level"),
                        rs.getBoolean("alive")
                ));
    }


    public void updateCharHealth(String name, Integer newHealth){
        jdbcTemplate.update("UPDATE rpg.rpg_character set health = ? WHERE name = ?",
                newHealth, name
        );
    }
}
