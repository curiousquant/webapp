package com.example;

import java.util.HashMap;
import java.util.List;

public class Board {
    HashMap<String,EquippedHero> team1, team2;
    HashMap<Integer,String> heros;
    HashMap<Integer,Sets> sets;
    ParseHeroJson p;

    public Board(HashMap<Integer,String> heros,HashMap<Integer,Sets> sets ){
        p = new ParseHeroJson();
        this.heros = heros;
        this.sets = sets;
        loadTeam1();
        loadTeam2();
    }
    public void attack(String from, String to){
        
    }
    public void loadTeam1(){
        team1.clear();
        team1.put(heros.get(0),p.readHeroStats(heros.get(0), sets.get(0)));
        team1.put(heros.get(1),p.readHeroStats(heros.get(1), sets.get(1)));
        team1.put(heros.get(2),p.readHeroStats(heros.get(2), sets.get(2)));
    }
    public void loadTeam2(){
        team2.clear();
        team2.put(heros.get(3),p.readHeroStats(heros.get(3), sets.get(3)));
        team2.put(heros.get(4),p.readHeroStats(heros.get(4), sets.get(4)));
        team2.put(heros.get(5),p.readHeroStats(heros.get(5), sets.get(5)));
    }
}