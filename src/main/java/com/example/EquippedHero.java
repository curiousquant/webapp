package com.example;

import java.util.HashMap;

public class EquippedHero extends Hero{
    final static double ATK_MODIFIER = 1.871;
    Sets set;
    HashMap<String,String> skills;
    double netAtk, netDef, netHp, s1dmg, s2dmg, s3dmg;
    int s1cd,s2cd,s3cd;
    public EquippedHero(String name,double atk, double def, double hp, double spd, 
                            double crit, double critdmg, double eff, double effres,
                                HashMap<String,String> skills,Sets set,int s1cd,int s2cd, int s3cd){
        super(name,atk,def,hp,spd,crit,critdmg,eff,effres);
        this.set = set;
        this.skills = skills;
        this.s1cd = s1cd;
        this.s2cd = s2cd;
        this.s3cd = s3cd;
        netAtk = calcAtk();
        netDef = calcDef();
        netHp = calcHp();
        s1dmg = calcS1();
        s2dmg = calcS2();
        s3dmg = calcS3();
                                    
        System.out.println(name);
        System.out.println("netAtk:"+netAtk);
        System.out.println("netDef:"+netDef);
        System.out.println("netHp:"+netHp);
        System.out.println("s1dmg:"+s1dmg);
        System.out.println("s2dmg:"+s2dmg);
        System.out.println("s3dmg:"+s3dmg);

    }   
    //Skill dmg = (Attack*att_rate*pow!)*1.871)
    public double calcS1(){
        return Math.max(0,netAtk*Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[1]+0))*
                        Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[2]+0))*ATK_MODIFIER);
        
    }
    public double calcS2(){
        return Math.max(0,netAtk*Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[1]+1))*
                        Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[2]+1))*ATK_MODIFIER);
        
    }
    public double calcS3(){
        return Math.max(0,netAtk*Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[1]+2))*
                        Double.parseDouble(skills.get(ParseHeroJson.SKILLATTRIBUTE[2]+2))*ATK_MODIFIER);
        
    }

    public double calcAtk(){
        return super.getAtk()*(1+(double)(set.getWeapon().getP_atk()+set.getHead().getP_atk()+
                                set.getChest().getP_atk()+set.getNeck().getP_atk()+
                                    set.getRing().getP_atk()+set.getBoot().getP_atk())/100.0) +

                                (double)(set.getWeapon().getF_atk()+set.getHead().getF_atk()+
                                    set.getChest().getF_atk()+set.getNeck().getF_atk()+
                                        set.getRing().getF_atk()+set.getBoot().getF_atk())
                                        ;
    
    }

    public double calcDef(){
        return super.getDef()*(1+(double)(set.getWeapon().getP_def()+set.getHead().getP_def()+
                                set.getChest().getP_def()+set.getNeck().getP_def()+
                                    set.getRing().getP_def()+set.getBoot().getP_def())/100) +

                                    (double)(set.getWeapon().getF_def()+set.getHead().getF_def()+
                                    set.getChest().getF_def()+set.getNeck().getF_def()+
                                        set.getRing().getF_def()+set.getBoot().getF_def())
                                        ;
    }

    public double calcHp(){
        return super.getHp()*(1+(double)(set.getWeapon().getP_hp()+set.getHead().getP_hp()+
                                set.getChest().getP_hp()+set.getNeck().getP_hp()+
                                    set.getRing().getP_hp()+set.getBoot().getP_hp())/100) +

                                    (double)(set.getWeapon().getF_hp()+set.getHead().getF_hp()+
                                    set.getChest().getF_hp()+set.getNeck().getF_hp()+
                                        set.getRing().getF_hp()+set.getBoot().getF_hp())
                                        ;
    }
    public void calcHero(){
        netAtk = calcAtk();
        netDef = calcDef();
        netHp = calcHp();
    }
    public HashMap<String,String> getSkills() {
        return this.skills;
    }

    public void setSkills(HashMap<String,String> skills) {
        this.skills = skills;
    }

    public Sets getSet() {
        return this.set;
    }

    public void setSet(Sets set) {
        this.set = set;
    }

    public double getNetAtk() {
        return this.netAtk;
    }

    public void setNetAtk(double netAtk) {
        this.netAtk = netAtk;
    }

    public double getNetDef() {
        return this.netDef;
    }

    public void setNetDef(double netDef) {
        this.netDef = netDef;
    }

    public double getNetHp() {
        return this.netHp;
    }

    public void setNetHp(double netHp) {
        this.netHp = netHp;
    }

    public double getS1dmg() {
        return this.s1dmg;
    }

    public void setS1dmg(double s1dmg) {
        this.s1dmg = s1dmg;
    }

    public double getS2dmg() {
        return this.s2dmg;
    }

    public void setS2dmg(double s2dmg) {
        this.s2dmg = s2dmg;
    }

    public double getS3dmg() {
        return this.s3dmg;
    }

    public void setS3dmg(double s3dmg) {
        this.s3dmg = s3dmg;
    }

    public int getS1cd() {
        return this.s1cd;
    }

    public void setS1cd(int s1cd) {
        this.s1cd = s1cd;
    }

    public int getS2cd() {
        return this.s2cd;
    }

    public void setS2cd(int s2cd) {
        this.s2cd = s2cd;
    }

    public int getS3cd() {
        return this.s3cd;
    }

    public void setS3cd(int s3cd) {
        this.s3cd = s3cd;
    }

}