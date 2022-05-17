package com.umusic.awesome_rpg.service;

import com.umusic.awesome_rpg.dao.CharacterDao;
import com.umusic.awesome_rpg.model.RPGCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CharacterService {

    @Autowired
    private CharacterDao characterDao;

    public void createCharacter(String name){
        RPGCharacter character = new RPGCharacter(name);
        characterDao.createCharacter(character.getName(), character.getHealth(),character.isAlive(), character.getLevel());
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

    public void attackCharacter(String name){
        Integer attackDamage = ThreadLocalRandom.current().nextInt(100, 200 + 1);
        characterDao.get

        characterDao.attack(name, damage);
    }


}
