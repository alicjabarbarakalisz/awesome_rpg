package com.umusic.awesome_rpg.service;

import com.umusic.awesome_rpg.dao.CharacterDao;
import com.umusic.awesome_rpg.model.RPGCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterDao characterDao;

    public void createCharacter(){
        RPGCharacter character = new RPGCharacter("Luke");

    }
    public RPGCharacter healCharacter(String name, int medication){
        RPGCharacter character = characterDao.getCharacter(name);
        Integer newHealth = character.getHealth() + medication;
        if(!character.isAlive() && newHealth > 999){
            return character;
        }
        character.setHealth(newHealth);
        characterDao.updateCharacter(character);

        return character;
    }

}
