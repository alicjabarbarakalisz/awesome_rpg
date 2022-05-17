package com.umusic.awesome_rpg.controller;

import com.umusic.awesome_rpg.model.RPGCharacter;
import com.umusic.awesome_rpg.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/create/{name}")
    public ResponseEntity<String> createCharacter(@PathVariable String name){
        return new ResponseEntity<String>(characterService.createCharacter(name), HttpStatus.OK);
    }

    @PostMapping("/lookAround/{name}")
    public ResponseEntity<String> lookAround(@PathVariable String name){
        return new ResponseEntity<String>(characterService.lookAround(name), HttpStatus.OK);
    }



    @PostMapping("/attack/{attackerName}/{defenderName}")
    public ResponseEntity<String> attack(@PathVariable String attackerName, @PathVariable String defenderName){
       return new ResponseEntity<String>(characterService.attackCharacter(attackerName, defenderName), HttpStatus.OK);
    }


    @PostMapping("/heal/{name}/{medication}")
    public ResponseEntity<String> healCharacter(@PathVariable String name, @PathVariable int medication){
        return new ResponseEntity<String>(characterService.healCharacter(name,medication), HttpStatus.OK);
    }

}
