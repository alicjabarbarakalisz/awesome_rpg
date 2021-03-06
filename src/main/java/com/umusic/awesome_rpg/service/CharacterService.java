package com.umusic.awesome_rpg.service;

import com.umusic.awesome_rpg.dao.CharacterDao;
import com.umusic.awesome_rpg.model.RPGCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private CharacterDao characterDao;

    public CharacterService(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    public String createCharacter(String name){
        RPGCharacter character = new RPGCharacter(name);
        characterDao.createCharacter(character.getName(), character.getHealth(),character.isAlive(), character.getLevel());
        return "Character " + name + " created";
    }

    public String lookAround(String name){

        List<RPGCharacter> aliveChars = characterDao.getAllAliveNPCCharacters(name);

        List<String> aliveNpcChars = aliveChars
                .stream()
                .map(RPGCharacter::getName)
                .toList();

        String info = "You, " + name + ", are a weary traveller in a local tavern, stopping for some well needed rest. " +
                "Around you is an assortment of shady looking characters looking for a fight, including " + aliveNpcChars + "." ;

        List<RPGCharacter> deadChars = characterDao.getAllDeadChars();

        List<String> deadCharNames = deadChars
                .stream()
                .map(RPGCharacter::getName)
                .toList();

        if (!deadCharNames.isEmpty()) {
            info = info + " Besides you lies the 'fainted' body of " + deadCharNames;
        }
        return info;
    }



    public String healCharacter(String name, int medication){
        RPGCharacter character = characterDao.getCharacter(name);
        Integer newHealth = character.getHealth() + medication;
        if(!character.isAlive() || newHealth > 999){
            return "Character must be alive and it's health can't be greater than 1000";
        }
        characterDao.updateCharHealth(name, newHealth, true);

        String info = "Character " + name + " is healthier. "+ name + " now has " + newHealth + " HP";

        return info;
    }

    public String attackCharacter(String attackerName, String defenderName){
        String info;
        if (attackerName.equals(defenderName)) {
            info = "A player cannot attack themselves! No self harm allowed in PG 13 rated RPG games.";
            return info;
        }
        RPGCharacter defender = characterDao.getCharacter(defenderName);
        RPGCharacter attacker = characterDao.getCharacter(attackerName);

        //Integer attackDamage = ThreadLocalRandom.current().nextInt(100, 200 + 1);

        Integer attackDamage = 100;
        if(defender.getLevel() > attacker.getLevel()+ 5){
            attackDamage = attackDamage - (attackDamage/2);
        }
        else if(attacker.getLevel() > defender.getLevel() + 5 ) {
            attackDamage = attackDamage + (attackDamage/2);
        }

        Integer newHealth = defender.getHealth() - attackDamage;

        characterDao.updateCharHealth(defenderName, newHealth, newHealth > 0);

        if (newHealth > 0) {
            info = "Character " + attackerName + " hit " + defenderName + " for " + attackDamage + " damage. " + defenderName + " now has " + newHealth + " HP";
        } else {
            info = "Character " + defenderName + " IS DEAD!!!!!!!";
        }

        return info;
    }


}
