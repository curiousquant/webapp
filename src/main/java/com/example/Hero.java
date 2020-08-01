package com.example;

import java.util.HashMap;

public class Hero {
    String name;
    double atk, def, hp, spd, crit, critdmg, eff, effres;
    double cv;
    public Hero(String name,double atk, double def, double hp, double spd, double crit, double critdmg, double eff, double effres){
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.spd = spd;
        this.crit = crit;
        this.critdmg = critdmg;
        this.eff = eff;
        this.effres = effres;
    }
    public Hero(){

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public double getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public double getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getSpd() {
        return this.spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public double getCrit() {
        return this.crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public double getCritdmg() {
        return this.critdmg;
    }

    public void setCritdmg(int critdmg) {
        this.critdmg = critdmg;
    }

    public double getEff() {
        return this.eff;
    }

    public void setEff(int eff) {
        this.eff = eff;
    }

    public double getEffres() {
        return this.effres;
    }

    public void setEffres(int effres) {
        this.effres = effres;
    }


}