package com.umusic.awesome_rpg.service;

import com.umusic.awesome_rpg.dao.CharacterDao;
import com.umusic.awesome_rpg.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterDao characterDao;

    public void createCharacter(){
        Character character = new Character("Luke");
        characterDao.createCharacter(character.getName(), character.getHealth(),character.isAlive(), character.getLevel());
    }

}
