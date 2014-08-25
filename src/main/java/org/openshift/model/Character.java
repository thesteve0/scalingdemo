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



    public Character() {
        allAttributes.put("Hit Points", rand.nextInt(MAX_HIT) + 1);
        allAttributes.put("Gold Pieces", rand.nextInt(MAX_GOLD) + 5);
        setAttributes(allAttributes);
        addRaceOrClass("Race", races, allAttributes);
        addRaceOrClass("Class", playerClass, allAttributes);

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
}
