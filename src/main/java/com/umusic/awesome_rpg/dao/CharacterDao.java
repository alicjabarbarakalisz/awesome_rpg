package com.umusic.awesome_rpg.dao;

import com.umusic.awesome_rpg.model.RPGCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveCharacter(Character character){
        jdbcTemplate.execute("INSERT INTO ");
    }

    public void updateCharacter(RPGCharacter character){
        jdbcTemplate.execute("UPDATE CHARACTER SET HEALTH = " + character.getHealth() + " where id = " + character.getId());
    }

}
