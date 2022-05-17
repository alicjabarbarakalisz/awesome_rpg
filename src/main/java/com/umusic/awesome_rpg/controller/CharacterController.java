package com.umusic.awesome_rpg.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @PostMapping("/create")
    public ResponseEntity<HttpEntity> createCharacter(){
        return null;
    }

}
