package com.umusic.awesome_rpg.controller;

import com.umusic.awesome_rpg.model.RPGCharacter;
import com.umusic.awesome_rpg.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<HttpEntity> createCharacter(){
        characterService.createCharacter();
        return null;
    }


    @PostMapping("/heal")
    public ResponseEntity<HttpEntity> healCharacter(String characterName, int medication){
        characterService.healCharacter(characterName, medication);
        return null;
    }

}
