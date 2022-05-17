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

    public void updateCharacter(RPGCharacter character){
        jdbcTemplate.execute("UPDATE CHARACTER SET HEALTH = " + character.getHealth() + " where id = " + character.getId());
    }

    public RPGCharacter getCharacter(String name){
        return jdbcTemplate.queryForObject("SLECT * FROM rpg.rpg_character WHERE name = :?", new Object[]{name}, (rs, rowNum) ->
                new RPGCharacter(
                        rs.getString("name"),
                        rs.getInt("health"),
                        rs.getInt("level"),
                        rs.getBoolean("alive")
                ));
    }

}
