package com.umusic.awesome_rpg.dao;

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

}
