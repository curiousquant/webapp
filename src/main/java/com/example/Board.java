package com.example;

import java.util.HashMap;
import java.util.Random;

public class Board {
    HashMap<Integer,EquippedHero> team1, team2;
    HashMap<Integer,String> heros;
    HashMap<Integer,Sets> sets;
    ParseHeroJson p;
    Random r;
    public Board(HashMap<Integer,String> heros,HashMap<Integer,Sets> sets ){
        p = new ParseHeroJson();
        team1 = new HashMap<Integer,EquippedHero>();
        team2 = new HashMap<Integer,EquippedHero>();
        this.heros = heros;
        this.sets = sets;
        loadTeam1();
        loadTeam2();
        r = new Random();
    }

    public void attack(int from, int[] to, int skill){
        
        for(int i=0;i<to.length;i++){
            if(from<=3){
                attack_subcalc(team1,team2,from,to[i],skill);
            }
            else{
                attack_subcalc(team2,team1,from,to[i],skill);
            }
        }
    }

    public void attack_subcalc(HashMap<Integer,EquippedHero> t1, 
                                HashMap<Integer,EquippedHero> t2, int from, int to, int skill){                         
        double dmg = 0;
        if(from<=2){
            if(skill==2 && Integer.parseInt(t1.get(from).getSkills().get("cooldown"+2))<=t1.get(from).getS3cd()){
                dmg = t1.get(from).getS3dmg();
                t1.get(from).setS3cd(0);
                t1.get(from).s2cd++;
                skill=2;
            }
            else if(skill==1 && Integer.parseInt(t1.get(from).getSkills().get("cooldown"+1))<=t1.get(from).getS2cd()){
                dmg = t1.get(from).getS2dmg();
                t1.get(from).setS2cd(0);
                t1.get(from).s3cd++;
                skill=1;
            }
            else{
                dmg = t1.get(from).getS1dmg();
                t1.get(from).s2cd++;
                t1.get(from).s3cd++;
                skill=0;
            }
            double rand = r.nextDouble();
            if(rand<t1.get(from).getCrit()/100.0){
                dmg = dmg*(t1.get(from).getCritdmg()/100);
                t2.get(to).setNetHp(t2.get(to).getNetHp()-dmg);
            }
            else{
                t2.get(to).setNetHp(t2.get(to).getNetHp()-dmg);
            }
            System.out.println(rand+" "+t1.get(from).getCrit()/100.0);
            System.out.println(t1.get(from).getName()+" atks for "+dmg+" to "+t2.get(to).getName()+" with skill "+skill);
        }
            
    }
    public void loadTeam1(){
        team1.clear();
        team1.put(0,p.readHeroStats(heros.get(0), sets.get(0)));
        team1.put(1,p.readHeroStats(heros.get(1), sets.get(1)));
        team1.put(2,p.readHeroStats(heros.get(2), sets.get(2)));
        team1.put(3,p.readHeroStats(heros.get(3), sets.get(3)));
    }
    public void loadTeam2(){
        team2.clear();
        team2.put(4,p.readHeroStats(heros.get(4), sets.get(4)));
        team2.put(5,p.readHeroStats(heros.get(5), sets.get(5)));
        team2.put(6,p.readHeroStats(heros.get(6), sets.get(6)));
        team2.put(7,p.readHeroStats(heros.get(7), sets.get(7)));
    }

    public static void main(String[] args) {
        Equipment weapon = new Weapon(0,1,500,0,0,9,0,8,8,0,13,0,0,"life");
        Equipment head= new Head(0,1,0,0,2700,8,0,25,11,0,2,0,0,"life");
        Equipment chest= new Chest(0,1,0,300,0,0,0,13,4,0,12,10,0,"life");
        Equipment neck= new Necklace(0,1,0,0,0,50,0,14,6,0,6,12,0,"life");
        Equipment ring= new Ring(0,1,0,0,0,50,0,11,7,0,5,10,0,"life");
        Equipment boot= new Boot(0,1,0,0,0,60,0,8,7,0,7,14,0,"life");
        Sets s = new Sets(weapon,head,chest,neck,ring,boot);


        HashMap<Integer,String> heros = new HashMap<Integer,String>();
        HashMap<Integer,Sets> sets = new HashMap<Integer,Sets>();

        sets.put(0,s);
        sets.put(1,s);
        sets.put(2,s);
        sets.put(3,s);
        sets.put(4,s);
        sets.put(5,s);
        sets.put(6,s);
        sets.put(7,s);

        heros.put(0,"alencia.json");
        heros.put(1,"achates.json");
        heros.put(2,"violet.json");
        heros.put(3,"vivian.json");
        heros.put(4,"wanda.json");
        heros.put(5,"yufine.json");
        heros.put(6,"aither.json");
        heros.put(7,"alexa.json");
        Board b = new Board(heros, sets);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
        b.attack(2, new int[]{4}, 2);
    }
}