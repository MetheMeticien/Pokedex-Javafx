package com.example.pokedex.models;

import com.example.pokedex.functions.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private List<String> types;
    private List<String> abilities;
    private String tier;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private List<String> nextEvolutions;
    private List<String> moves;

    // Constructor
    public Pokemon(String name, List<String> types, List<String> abilities, String tier, int hp, int attack, int defense,
                   int specialAttack, int specialDefense, int speed, List<String> nextEvolutions, List<String> moves) {
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.tier = tier;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.nextEvolutions = nextEvolutions;
        this.moves = moves;
    }

    public Pokemon() {

    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        List<String> parsedTypes = new ArrayList<String>();
        for (int i = 0; i < types.size(); i++) {

            if(i==0) types.set(i,types.get(i).substring(2, types.get(i).length() - 1));
            else if(i==types.size()-1) types.set(i,types.get(i).substring(1, types.get(i).length() - 2));
            else types.set(i,types.get(i).substring(1, types.get(i).length() - 1));
            parsedTypes.add(types.get(i));
        }
        this.types = parsedTypes;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getNextEvolutions() {
        return nextEvolutions;
    }

    public void setNextEvolutions(List<String> nextEvolutions) {
        List<String> parsedevol = new ArrayList<String>();
        for (int i = 0; i < nextEvolutions.size(); i++) {


            System.out.println(nextEvolutions.size());
            System.out.println(nextEvolutions.get(i));
            System.out.println(nextEvolutions.get(i).length());
            if(i==0){
                if(nextEvolutions.get(i).length() < 3){
                    nextEvolutions.set(i,nextEvolutions.get(i).substring(0, nextEvolutions.get(i).length() - 0));
                }
                else{
                    nextEvolutions.set(i,nextEvolutions.get(i).substring(2, nextEvolutions.get(i).length() - 2));
                }
            }
            else if(i==nextEvolutions.size()-1) nextEvolutions.set(i,nextEvolutions.get(i).substring(1, nextEvolutions.get(i).length() - 2));
            else nextEvolutions.set(i,nextEvolutions.get(i).substring(1, nextEvolutions.get(i).length() - 1));
            parsedevol.add(nextEvolutions.get(i));
        }
        this.nextEvolutions = parsedevol;
    }

    public List<String> getMoves() {
        return moves;

    }

    public void setMoves(List<String> moves) {
        List<String> parsedMoves = new ArrayList<String>();
        for (int i = 0; i < moves.size(); i++) {

            if(i==0) moves.set(i,moves.get(i).substring(2, moves.get(i).length() - 1));
            else if(i==moves.size()-1) moves.set(i,moves.get(i).substring(1, moves.get(i).length() - 2));
            else moves.set(i,moves.get(i).substring(1, moves.get(i).length() - 1));
            parsedMoves.add(moves.get(i));
        }
        this.moves = parsedMoves;
    }




    public void mapResultSetToPokemon(ResultSet resultSet) throws SQLException {
        functions func = new functions();


        this.setName(resultSet.getString("Name"));
        this.setTypes(func.parseStringToList(resultSet.getString("Types")));
        this.setAbilities(func.parseStringToList(resultSet.getString("Abilities")));
        this.setTier(resultSet.getString("Tier"));
        this.setHp(resultSet.getInt("HP"));
        this.setAttack(resultSet.getInt("Attack"));
        this.setDefense(resultSet.getInt("Defense"));
        this.setSpecialAttack(resultSet.getInt("Special Attack"));
        this.setSpecialDefense(resultSet.getInt("Special Defense"));
        this.setSpeed(resultSet.getInt("Speed"));
        this.setNextEvolutions(func.parseStringToList(resultSet.getString("Next Evolutions")));
        this.setMoves(func.parseStringToList(resultSet.getString("Moves")));

    }
}
