package com.umusic.awesome_rpg.service;

import com.umusic.awesome_rpg.dao.CharacterDao;
import com.umusic.awesome_rpg.model.RPGCharacter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceTest {

    private CharacterService service;
    @Mock
    private CharacterDao characterDao;

    @Before
    public void setup(){
        service = new CharacterService(characterDao);
    }

    @Test
    public void attackCharacterKillTest(){
        RPGCharacter character = new RPGCharacter("Saturninus");
        character.setAlive(true);
        character.setHealth(50);
        character.setLevel(3);

        when(characterDao.getCharacter("Saturninus")).thenReturn(character);
        String response = service.attackCharacter("Saturninus");

        assertEquals("Character Saturninus IS DEAD!!!!!!!", response);

    }

    @Test
    public void attackCharacterTest(){
        RPGCharacter character = new RPGCharacter("Saturninus");
        character.setAlive(true);
        character.setHealth(500);
        character.setLevel(3);

        when(characterDao.getCharacter("Saturninus")).thenReturn(character);
        String response = service.attackCharacter("Saturninus");

        assertEquals("Character Saturninus IS DEAD!!!!!!!", response);

    }

    @Test
    public void healCharacterTest(){
        RPGCharacter character = new RPGCharacter("Saturninus");
        character.setAlive(true);
        character.setHealth(50);
        character.setLevel(3);

        when(characterDao.getCharacter("Saturninus")).thenReturn(character);
        String response = service.healCharacter("Saturninus", 5);

        assertEquals("Character Saturninus is healthier. Saturninus now has 55 HP", response);

    }

    @Test
    public void healDeadCharacterFailsTest(){
        RPGCharacter character = new RPGCharacter("Saturninus");
        character.setAlive(false);
        character.setHealth(50);
        character.setLevel(3);

        when(characterDao.getCharacter("Saturninus")).thenReturn(character);
        String response = service.healCharacter("Saturninus", 5);

        assertEquals("Character must be alive and it's health can't be greater than 1000", response);

    }

    @Test
    public void healCharacterFailsTest(){
        RPGCharacter character = new RPGCharacter("Saturninus");
        character.setAlive(false);
        character.setHealth(50);
        character.setLevel(3);

        when(characterDao.getCharacter("Saturninus")).thenReturn(character);
        String response = service.healCharacter("Saturninus", 3000);

        assertEquals("Character must be alive and it's health can't be greater than 1000", response);

    }


}
