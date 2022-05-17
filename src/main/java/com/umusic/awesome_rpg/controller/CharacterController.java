package com.umusic.awesome_rpg.controller;

import com.umusic.awesome_rpg.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/create/{name}")
    public ResponseEntity<HttpEntity> createCharacter(@PathVariable String name){
        characterService.createCharacter(name);
        return null;
    }


    @PostMapping("/attack/{name}")
    public ResponseEntity<HttpEntity> attack(@PathVariable String name){
       // characterService.createCharacter();
        return null;
    }

}
