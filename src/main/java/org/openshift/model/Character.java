package org.openshift.model;

import java.util.*;
import static java.util.Arrays.asList;

/**
 * Created by spousty on 8/22/14.
 */
public class Character {
    Random rand = new Random();
    private int  hitPoints, goldPieces;
    private final HashSet<String> attributeNames =  new HashSet<String>(asList("Strength", "Intelligence", "Charisma", "Wisdom", "Dexterity", "Constitution"));
    private List<String> races =  asList( "Human", "Dwarf", "Halfling", "Elf", "Gnome", "Half-Elf", "Half-Orc", "Nerd");
    private List<String> playerClass =  asList("Warrior", "Ranger", "Paladin", "Cleric", "Monk", "Wizard", "Thief", "Assassin", "Druid", "Wizard", "Coder");
    private HashMap allAttributes = new HashMap(18);

    private final int MAX_GOLD = 200;
    private final int MAX_HIT = 9;

    //TODO still need some random ID for the character
    //TODO give a method where if a name is passed in we give it a name

    public Character(){

        this(UUID.randomUUID().toString());

    }

    public Character(String name) {
        allAttributes.put("Hit Points", rand.nextInt(MAX_HIT) + 1);
        allAttributes.put("Gold Pieces", rand.nextInt(MAX_GOLD) + 5);
        setAttributes(allAttributes);
        addRaceOrClass("Race", races, allAttributes);
        addRaceOrClass("Class", playerClass, allAttributes);
        allAttributes.put("Name", name);

    }

    private void setAttributes(HashMap aAttributes){
        //Roll up the normal attributes
        for (String name: attributeNames){
            aAttributes.put(name, rand.nextInt(17) + 1);
        }

    }

    private void addRaceOrClass(String attName, List<String> raceOrClass, HashMap aAttributes){

        int listSize = raceOrClass.size();
        aAttributes.put(attName, raceOrClass.get(rand.nextInt(listSize)));
    }

    public HashMap getAllAttributes(){
        return allAttributes;
    }

    public void setName(String name){
        allAttributes.put("Name", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (goldPieces != character.goldPieces) return false;
        if (hitPoints != character.hitPoints) return false;
        if (allAttributes != null ? !allAttributes.equals(character.allAttributes) : character.allAttributes != null)
            return false;
        if (attributeNames != null ? !attributeNames.equals(character.attributeNames) : character.attributeNames != null)
            return false;
        if (playerClass != null ? !playerClass.equals(character.playerClass) : character.playerClass != null)
            return false;
        if (races != null ? !races.equals(character.races) : character.races != null) return false;
        if (rand != null ? !rand.equals(character.rand) : character.rand != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = rand != null ? rand.hashCode() : 0;
        result = 31 * result + hitPoints;
        result = 31 * result + goldPieces;
        result = 31 * result + (allAttributes != null ? allAttributes.hashCode() : 0);
        result = 31 * rand.nextInt();
        return result;
    }
}
