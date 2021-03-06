package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.Utilsv1;

public class Bagv2 {
    String[] heroNames;
    String[][] strInventory;
    int[][] heroStats,wInventory,hInventory,chInventory,nInventory,rInventory,bInventory;
    int wCntr = 0;
    int hCntr = 0;
    int chCntr = 0;
    int nCntr = 0;
    int rCntr = 0;
    int bCntr = 0;
    int strCntr = 0;
    
    
    ArrayList<Equipment> wlist = new ArrayList<>();
    ArrayList<Equipment> hlist = new ArrayList<>();
    ArrayList<Equipment> chlist = new ArrayList<>();
    ArrayList<Equipment> nlist = new ArrayList<>();
    ArrayList<Equipment> rlist = new ArrayList<>();
    ArrayList<Equipment> blist = new ArrayList<>();

    ArrayList<Sets> history = new ArrayList<>();
    ArrayList<Hero> heros = new ArrayList<>();

    Sets set = new Sets();
    public Bagv2(){

    }

    public boolean isAtkSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("atk"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("atk"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("atk"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("atk"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("atk"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("atk"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb>=4;

    }
    public int isDefSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("def"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("def"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("def"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("def"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("def"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("def"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }
    public int isHpSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("hp"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("hp"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("hp"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("hp"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("hp"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("hp"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }
    public int isCSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("crit"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("crit"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("crit"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("crit"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("crit"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("crit"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }
    public int isCdSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("dest"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("dest"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("dest"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("dest"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("dest"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("dest"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }
    public int isSpdSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("spd"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("spd"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("spd"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("spd"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("spd"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+nCntr+rCntr+n][1].equals("spd"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }

    public int isEffSet(int i, int j, int k, int l, int m, int n){
        int setw = (strInventory[i][1].equals("eff"))? 1 : 0;
        int seth = (strInventory[wCntr+j][1].equals("eff"))? 1 : 0;
        int setch = (strInventory[wCntr+hCntr+k][1].equals("eff"))? 1 : 0;
        int setn = (strInventory[wCntr+hCntr+chCntr+l][1].equals("eff"))? 1 : 0;
        int setr = (strInventory[wCntr+hCntr+chCntr+nCntr+m][1].equals("eff"))? 1 : 0;
        int setb = (strInventory[wCntr+hCntr+chCntr+rCntr+nCntr+n][1].equals("eff"))? 1 : 0;
        return setw+seth+setch+setn+setr+setb;

    }

 //int pk int f_atk = 0, f_def = 0, f_hp = 0, p_atk = 0, p_def = 0, p_hp = 0, c = 0, cd = 0, spd = 0, eff = 0, effres = 0;
    public Sets runCalcs(Hero hero,boolean isAtk,boolean isDef, boolean isHp, 
                            boolean isCrit, boolean isCd, boolean isSpd,boolean isEff, boolean isSpecial,
                            double maxAtk,double maxDef,double maxHp, double maxC,
                            double maxCd, double maxSpd, double maxEff){
        int maxI=0,maxJ=0,maxK=0,maxL=0,maxM=0,maxN=0;
        //double maxAtk = 0,maxDef = 0,maxHp = 0,maxC = 0,maxCd = 0,maxEff = 0,maxSpd = 0;
        double heroatk = hero.getAtk(),herodef = hero.getDef(),herohp = hero.getHp(),
        herocrit = hero.getCrit(),heroCd = hero.getCritdmg(),heroSpd =hero.getSpd(),heroEff = hero.getEff();
        ;
        double atk=0;
        double def=0;
        double hp=0;
        double crit = 0;
        double cd = 0;
        double eff = 0;
        double spd = 0;
        double dps = 0;
        double maxDps = 0;
        
        for(int i=0;i<wCntr;i++){
            for(int j=0;j<hCntr;j++){
                for(int k=0;k<chCntr;k++){
                    for(int l=0;l<nCntr;l++){
                        for(int m=0;m<rCntr;m++){
                            for(int n=0; n<bCntr;n++){
                                

                                if(isAtk||maxAtk!=0){
                                    if(isAtkSet(i,j,k,l,m,n)){
                                        atk = wInventory[i][1]+hInventory[j][1]+chInventory[k][1]
                                            +nInventory[l][1]+rInventory[m][1]+bInventory[n][1]
                                            + heroatk*(1+(double)(35.0+wInventory[i][4]+hInventory[j][4]+chInventory[k][4]
                                            +nInventory[l][4]+rInventory[m][4]+bInventory[n][4])/100);
                                    }
                                    else{
                                        atk = wInventory[i][1]+hInventory[j][1]+chInventory[k][1]
                                            +nInventory[l][1]+rInventory[m][1]+bInventory[n][1]
                                            + heroatk*(1+(double)(wInventory[i][4]+hInventory[j][4]+chInventory[k][4]
                                            +nInventory[l][4]+rInventory[m][4]+bInventory[n][4])/100);
                                    }
                                }
                                if(isSpecial){
                                    if(isAtkSet(i,j,k,l,m,n)){
                                        atk = wInventory[i][1]+hInventory[j][1]+chInventory[k][1]
                                            +nInventory[l][1]+rInventory[m][1]+bInventory[n][1]
                                            + heroatk*(1+(double)(35+wInventory[i][4]+hInventory[j][4]+chInventory[k][4]
                                            +nInventory[l][4]+rInventory[m][4]+bInventory[n][4])/100);
                                            
                                    }
                                    else{
                                        atk = wInventory[i][1]+hInventory[j][1]+chInventory[k][1]
                                            +nInventory[l][1]+rInventory[m][1]+bInventory[n][1]
                                            + heroatk*(1+(double)(wInventory[i][4]+hInventory[j][4]+chInventory[k][4]
                                            +nInventory[l][4]+rInventory[m][4]+bInventory[n][4])/100);
                                    }

                                    if(isCSet(i,j,k,l,m,n)==6){
                                        crit = herocrit+(double)(12*3+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else if(isCSet(i,j,k,l,m,n)>=4){
                                        crit = herocrit+(double)(12*2+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else if(isCSet(i,j,k,l,m,n)>=2){
                                        crit = herocrit+(double)(12*1+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else{
                                        crit = herocrit+(double)(wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }

                                    if(isCdSet(i,j,k,l,m,n)>=4){
                                        cd = heroCd+(double)(40+wInventory[i][8]+hInventory[j][8]+chInventory[k][8]
                                        +nInventory[l][8]+rInventory[m][8]+bInventory[n][8]);
                                    }
                                    else{
                                        cd = heroCd+(double)(wInventory[i][8]+hInventory[j][8]+chInventory[k][8]
                                        +nInventory[l][8]+rInventory[m][8]+bInventory[n][8]);
                                    }
                                    if(crit>100){
                                        crit=100;
                                    }
                                    dps = atk*(1-crit/100)+atk*(cd/100)*crit/100;
                                    
                                }
                                if(isDef||maxDef!=0){
                                    if(isDefSet(i,j,k,l,m,n)==6){
                                        def = wInventory[i][2]+hInventory[j][2]+chInventory[k][2]
                                        +nInventory[l][2]+rInventory[m][2]+bInventory[n][2]
                                        + herodef*(1+(double)(15*3+wInventory[i][5]+hInventory[j][5]+chInventory[k][5]
                                        +nInventory[l][5]+rInventory[m][5]+bInventory[n][5])/100);
                                    }
                                    else if(isDefSet(i,j,k,l,m,n)>=4){
                                        def = wInventory[i][2]+hInventory[j][2]+chInventory[k][2]
                                        +nInventory[l][2]+rInventory[m][2]+bInventory[n][2]
                                        + herodef*(1+(double)15*2+(wInventory[i][5]+hInventory[j][5]+chInventory[k][5]
                                        +nInventory[l][5]+rInventory[m][5]+bInventory[n][5])/100);
                                    }
                                    else if(isDefSet(i,j,k,l,m,n)>=2){
                                        def = wInventory[i][2]+hInventory[j][2]+chInventory[k][2]
                                        +nInventory[l][2]+rInventory[m][2]+bInventory[n][2]
                                        + herodef*(1+(double)(15*1+wInventory[i][5]+hInventory[j][5]+chInventory[k][5]
                                        +nInventory[l][5]+rInventory[m][5]+bInventory[n][5])/100);
                                    }
                                    else{
                                        def = wInventory[i][2]+hInventory[j][2]+chInventory[k][2]
                                        +nInventory[l][2]+rInventory[m][2]+bInventory[n][2]
                                        + herodef*(1+(double)(15*1+wInventory[i][5]+hInventory[j][5]+chInventory[k][5]
                                        +nInventory[l][5]+rInventory[m][5]+bInventory[n][5])/100);
                                    }
                                }
                                
                                if(isHp||maxHp!=0){
                                    if(isHpSet(i,j,k,l,m,n)==6){
                                        hp = wInventory[i][3]+hInventory[j][3]+chInventory[k][3]
                                        +nInventory[l][3]+rInventory[m][3]+bInventory[n][3]
                                        + herohp*(1+(double)(15*3+wInventory[i][6]+hInventory[j][6]+chInventory[k][6]
                                        +nInventory[l][6]+rInventory[m][6]+bInventory[n][6])/100);
                                    }
                                    else if(isHpSet(i,j,k,l,m,n)>=4){
                                        hp = wInventory[i][3]+hInventory[j][3]+chInventory[k][3]
                                        +nInventory[l][3]+rInventory[m][3]+bInventory[n][3]
                                        + herohp*(1+(double)(15*2+wInventory[i][6]+hInventory[j][6]+chInventory[k][6]
                                        +nInventory[l][6]+rInventory[m][6]+bInventory[n][6])/100);
                                    }
                                    else if(isHpSet(i,j,k,l,m,n)>=2){
                                        hp = wInventory[i][3]+hInventory[j][3]+chInventory[k][3]
                                        +nInventory[l][3]+rInventory[m][3]+bInventory[n][3]
                                        + herohp*(1+(double)(15*1+wInventory[i][6]+hInventory[j][6]+chInventory[k][6]
                                        +nInventory[l][6]+rInventory[m][6]+bInventory[n][6])/100);
                                    }
                                    else {
                                        hp = wInventory[i][3]+hInventory[j][3]+chInventory[k][3]
                                        +nInventory[l][3]+rInventory[m][3]+bInventory[n][3]
                                        + herohp*(1+(double)(wInventory[i][6]+hInventory[j][6]+chInventory[k][6]
                                        +nInventory[l][6]+rInventory[m][6]+bInventory[n][6])/100);
                                    }
                                }
                                if(isCrit||maxC!=0){
                                    if(isCSet(i,j,k,l,m,n)==6){
                                        crit = herocrit+(double)(12*3+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else if(isCSet(i,j,k,l,m,n)>=4){
                                        crit = herocrit+(double)(12*2+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else if(isCSet(i,j,k,l,m,n)>=2){
                                        crit = herocrit+(double)(12*1+wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                    else{
                                        crit = herocrit+(double)(wInventory[i][7]+hInventory[j][7]+chInventory[k][7]
                                        +nInventory[l][7]+rInventory[m][7]+bInventory[n][7]);
                                    }
                                }
                                
                                if(isCd||maxCd!=0){
                                    if(isCdSet(i,j,k,l,m,n)>=4){
                                        cd = heroCd+(double)(40+wInventory[i][8]+hInventory[j][8]+chInventory[k][8]
                                        +nInventory[l][8]+rInventory[m][8]+bInventory[n][8]);
                                    }
                                    else{
                                        cd = heroCd+(double)(wInventory[i][8]+hInventory[j][8]+chInventory[k][8]
                                        +nInventory[l][8]+rInventory[m][8]+bInventory[n][8]);
                                    }
                                }

                                if(isSpd||maxSpd!=0){
                                    if(isSpdSet(i,j,k,l,m,n)>=4){
                                        spd = 1.25*heroSpd+(double)(wInventory[i][9]+hInventory[j][9]+chInventory[k][9]
                                        +nInventory[l][9]+rInventory[m][9]+bInventory[n][9]);
                                    }
                                    else{
                                        spd = heroSpd+(double)(wInventory[i][9]+hInventory[j][9]+chInventory[k][9]
                                        +nInventory[l][9]+rInventory[m][9]+bInventory[n][9]);
                                    }
                                }

                                if(isEff||maxEff!=0){
                                    if(isEffSet(i,j,k,l,m,n)==6){
                                        eff = heroEff+(double)(20*3+wInventory[i][10]+hInventory[j][10]+chInventory[k][10]
                                        +nInventory[l][10]+rInventory[m][10]+bInventory[n][10]);
                                    }
                                    else if(isEffSet(i,j,k,l,m,n)==6){
                                        eff = heroEff+(double)(20*2+wInventory[i][10]+hInventory[j][10]+chInventory[k][10]
                                        +nInventory[l][10]+rInventory[m][10]+bInventory[n][10]);
                                    }
                                    else if(isEffSet(i,j,k,l,m,n)==6){
                                        eff = heroEff+(double)(20*1+wInventory[i][10]+hInventory[j][10]+chInventory[k][10]
                                        +nInventory[l][10]+rInventory[m][10]+bInventory[n][10]);
                                    }
                                    else{
                                        eff = heroEff+(double)(wInventory[i][10]+hInventory[j][10]+chInventory[k][10]
                                        +nInventory[l][10]+rInventory[m][10]+bInventory[n][10]);
                                    }

                                }
                                if(maxDps<=dps){
                                    if(maxAtk<=atk ){
                                        if(maxHp<=hp){
                                            if(maxDef<=def){
                                                if(maxC <= crit&&maxCd<=cd&&maxSpd<=spd&&maxEff<=eff){
                                                    if(isSpecial){
                                                        maxDps = dps;
                                                        
                                                    }
                                                    if(isAtk){
                                                        maxAtk = atk;
                                                    }
                                                    if(isDef){
                                                        maxDef = def;
                                                    }
                                                    if(isHp){
                                                        maxHp = hp;
                                                    }
                                                    if(isCrit){
                                                        maxC = crit;
                                                    }
                                                    if(isCd){
                                                        maxCd = cd;
                                                    }
                                                    if(isSpd){
                                                        maxSpd = spd;
                                                    }
                                                    if(isEff){
                                                        maxEff = eff;
                                                    }
                                                    maxI =i;//wInventory[i][0];
                                                    maxJ =j;//hInventory[j][0];
                                                    maxK =k;//chInventory[k][0];
                                                    maxL =l;//nInventory[l][0];
                                                    maxM =m;//rInventory[m][0];
                                                    maxN =n;//bInventory[n][0];
                                                    //System.out.println(spd);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return outputSets(maxI, maxJ, maxK, maxL, maxM, maxN);
        
    }

    public ArrayList<Hero> calcHero(Hero hero, ArrayList<Equipment> sets){
        ArrayList<Hero> h = new ArrayList<>();
        double hatk=0,hdef=0,hhp=0,hspd=0,hcc=0,hcd=0,he=0,her=0;

        int setw = (sets.get(0).getSet().equals("atk"))? 1 : 0;
        int seth = (sets.get(1).getSet().equals("atk"))? 1 : 0;
        int setch = (sets.get(2).getSet().equals("atk"))? 1 : 0;
        int setn = (sets.get(3).getSet().equals("atk"))? 1 : 0;
        int setr = (sets.get(4).getSet().equals("atk"))? 1 : 0;
        int setb = (sets.get(5).getSet().equals("atk"))? 1 : 0;

        if(setw+seth+setch+setn+setr+setb>=4){
            hatk = hero.getAtk()*(1+(double)(35.0+sets.get(0).getP_atk()+sets.get(1).getP_atk()+sets.get(2).getP_atk()
            + sets.get(3).getP_atk()+sets.get(4).getP_atk()+sets.get(5).getP_atk())/100)
            +(sets.get(0).getF_atk()+sets.get(1).getF_atk()+sets.get(2).getF_atk()
            + sets.get(3).getF_atk()+sets.get(4).getF_atk()+sets.get(5).getF_atk())
            ;
        }
        else{
            hatk = hero.getAtk()*(1+(double)(sets.get(0).getP_atk()+sets.get(1).getP_atk()+sets.get(2).getP_atk()
            + sets.get(3).getP_atk()+sets.get(4).getP_atk()+sets.get(5).getP_atk())/100)
            +(sets.get(0).getF_atk()+sets.get(1).getF_atk()+sets.get(2).getF_atk()
            + sets.get(3).getF_atk()+sets.get(4).getF_atk()+sets.get(5).getF_atk())
            ;

        }
        setw = (sets.get(0).getSet().equals("def"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("def"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("def"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("def"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("def"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("def"))? 1 : 0;

        if(setw+seth+setch+setn+setr+setb==6){
            hdef = hero.getDef()*(1+((double)(15*3+sets.get(0).getP_def()+sets.get(1).getP_def()+sets.get(2).getP_def()
            + sets.get(3).getP_def()+sets.get(4).getP_def()+sets.get(5).getP_def())/100)
            +sets.get(0).getF_def()+sets.get(1).getF_def()+sets.get(2).getF_def()
            + sets.get(3).getF_def()+sets.get(4).getF_def()+sets.get(5).getF_def())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=4){
            hdef = hero.getDef()*(1+(double)(15*2+sets.get(0).getP_def()+sets.get(1).getP_def()+sets.get(2).getP_def()
            + sets.get(3).getP_def()+sets.get(4).getP_def()+sets.get(5).getP_def())/100)
            +(sets.get(0).getF_def()+sets.get(1).getF_def()+sets.get(2).getF_def()
            + sets.get(3).getF_def()+sets.get(4).getF_def()+sets.get(5).getF_def())
            ;
        }
        else if (setw+seth+setch+setn+setr+setb>=2){
            hdef = hero.getDef()*(1+(double)(15*1+sets.get(0).getP_def()+sets.get(1).getP_def()+sets.get(2).getP_def()
            + sets.get(3).getP_def()+sets.get(4).getP_def()+sets.get(5).getP_def())/100)
            +(sets.get(0).getF_def()+sets.get(1).getF_def()+sets.get(2).getF_def()
            + sets.get(3).getF_def()+sets.get(4).getF_def()+sets.get(5).getF_def())
            ;
        }
        else{
            hdef = hero.getDef()*(1+(double)(sets.get(0).getP_def()+sets.get(1).getP_def()+sets.get(2).getP_def()
            + sets.get(3).getP_def()+sets.get(4).getP_def()+sets.get(5).getP_def())/100)
            +(sets.get(0).getF_def()+sets.get(1).getF_def()+sets.get(2).getF_def()
            + sets.get(3).getF_def()+sets.get(4).getF_def()+sets.get(5).getF_def())
            ;
            
        }
        
        setw = (sets.get(0).getSet().equals("hp"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("hp"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("hp"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("hp"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("hp"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("hp"))? 1 : 0;
        if(setw+seth+setch+setn+setr+setb==6){
            hhp = hero.getHp()*(1+(double)(1+sets.get(0).getP_hp()+sets.get(1).getP_hp()+sets.get(2).getP_hp()
                                            + sets.get(3).getP_hp()+sets.get(4).getP_hp()+sets.get(5).getP_hp())/100)
                                            +(15*3+sets.get(0).getF_hp()+sets.get(1).getF_hp()+sets.get(2).getF_hp()
                                            + sets.get(3).getF_hp()+sets.get(4).getF_hp()+sets.get(5).getF_hp())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=4){
            hhp = hero.getHp()*(1+(double)(1+sets.get(0).getP_hp()+sets.get(1).getP_hp()+sets.get(2).getP_hp()
                                            + sets.get(3).getP_hp()+sets.get(4).getP_hp()+sets.get(5).getP_hp())/100)
                                            +(15*2+sets.get(0).getF_hp()+sets.get(1).getF_hp()+sets.get(2).getF_hp()
                                            + sets.get(3).getF_hp()+sets.get(4).getF_hp()+sets.get(5).getF_hp())
            ;
        }
        if(setw+seth+setch+setn+setr+setb>=2){
            hhp = hero.getHp()*(1+(double)(1+sets.get(0).getP_hp()+sets.get(1).getP_hp()+sets.get(2).getP_hp()
                                            + sets.get(3).getP_hp()+sets.get(4).getP_hp()+sets.get(5).getP_hp())/100)
                                            +(15*1+sets.get(0).getF_hp()+sets.get(1).getF_hp()+sets.get(2).getF_hp()
                                            + sets.get(3).getF_hp()+sets.get(4).getF_hp()+sets.get(5).getF_hp())
            ;
        }
        else{
            hhp = hero.getHp()*(1+(double)(1+sets.get(0).getP_hp()+sets.get(1).getP_hp()+sets.get(2).getP_hp()
            + sets.get(3).getP_hp()+sets.get(4).getP_hp()+sets.get(5).getP_hp())/100)
            +(sets.get(0).getF_hp()+sets.get(1).getF_hp()+sets.get(2).getF_hp()
            + sets.get(3).getF_hp()+sets.get(4).getF_hp()+sets.get(5).getF_hp())
            ;

        }
        
        setw = (sets.get(0).getSet().equals("spd"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("spd"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("spd"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("spd"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("spd"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("spd"))? 1 : 0;

        if(setw+seth+setch+setn+setr+setb>=4){
            hspd = 1.25*hero.getSpd()+(sets.get(0).getSpd()+sets.get(1).getSpd()+sets.get(2).getSpd()
            + sets.get(3).getSpd()+sets.get(4).getSpd()+sets.get(5).getSpd())
            ;
        }
        else{
            hspd = hero.getSpd()+(sets.get(0).getSpd()+sets.get(1).getSpd()+sets.get(2).getSpd()
                                            + sets.get(3).getSpd()+sets.get(4).getSpd()+sets.get(5).getSpd())
            ;
        }
        setw = (sets.get(0).getSet().equals("crit"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("crit"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("crit"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("crit"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("crit"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("crit"))? 1 : 0;
        if(setw+seth+setch+setn+setr+setb==6){
            hcc = hero.getCrit()+(12*3+sets.get(0).getC()+sets.get(1).getC()+sets.get(2).getC()
            + sets.get(3).getC()+sets.get(4).getC()+sets.get(5).getC())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=4){
            hcc = hero.getCrit()+(12*2+sets.get(0).getC()+sets.get(1).getC()+sets.get(2).getC()
            + sets.get(3).getC()+sets.get(4).getC()+sets.get(5).getC())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=4){
            hcc = hero.getCrit()+(12*1+sets.get(0).getC()+sets.get(1).getC()+sets.get(2).getC()
            + sets.get(3).getC()+sets.get(4).getC()+sets.get(5).getC())
            ;
        }
        else{
            hcc = hero.getCrit()+(sets.get(0).getC()+sets.get(1).getC()+sets.get(2).getC()
            + sets.get(3).getC()+sets.get(4).getC()+sets.get(5).getC())
            ;

        }
        setw = (sets.get(0).getSet().equals("des"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("des"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("des"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("des"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("des"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("des"))? 1 : 0;
        
        if(setw+seth+setch+setn+setr+setb>=4){
            hcd = hero.getCritdmg() +(40+sets.get(0).getCd()+sets.get(1).getCd()+sets.get(2).getCd()
                                            + sets.get(3).getCd()+sets.get(4).getCd()+sets.get(5).getCd())
            ;
        }
        else {
            hcd = hero.getCritdmg() +(sets.get(0).getCd()+sets.get(1).getCd()+sets.get(2).getCd()
                                            + sets.get(3).getCd()+sets.get(4).getCd()+sets.get(5).getCd())
            ;
        }
        setw = (sets.get(0).getSet().equals("eff"))? 1 : 0;
        seth = (sets.get(1).getSet().equals("eff"))? 1 : 0;
        setch = (sets.get(2).getSet().equals("eff"))? 1 : 0;
        setn = (sets.get(3).getSet().equals("eff"))? 1 : 0;
        setr = (sets.get(4).getSet().equals("eff"))? 1 : 0;
        setb = (sets.get(5).getSet().equals("eff"))? 1 : 0;
        if(setw+seth+setch+setn+setr+setb==6){
            he = hero.getEff()+(20*3+sets.get(0).getEff()+sets.get(1).getEff()+sets.get(2).getEff()
                                            + sets.get(3).getEff()+sets.get(4).getEff()+sets.get(5).getEff())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=4){
            he = hero.getEff()+(20*2+sets.get(0).getEff()+sets.get(1).getEff()+sets.get(2).getEff()
                                            + sets.get(3).getEff()+sets.get(4).getEff()+sets.get(5).getEff())
            ;
        }
        else if(setw+seth+setch+setn+setr+setb>=2){
            he = hero.getEff()+(20*1+sets.get(0).getEff()+sets.get(1).getEff()+sets.get(2).getEff()
                                            + sets.get(3).getEff()+sets.get(4).getEff()+sets.get(5).getEff())
            ;
        }
        else{
            he = hero.getEff()+(sets.get(0).getEff()+sets.get(1).getEff()+sets.get(2).getEff()
            + sets.get(3).getEff()+sets.get(4).getEff()+sets.get(5).getEff())
            ;
        }
        
        her = hero.getEffres()+(sets.get(0).getEffres()+sets.get(1).getEffres()+sets.get(2).getEffres()
                                            + sets.get(3).getEffres()+sets.get(4).getEffres()+sets.get(5).getEffres())
                            
        ;

        h.add(new Hero(hero.getName(),(int)(hatk),(int)(hdef),(int)(hhp),(int)(hspd),(int)(hcc),(int)(hcd),(int)(he),(int)(her)));
        
        return h;
    }


    public Sets outputSets(int i, int j, int k, int l, int m, int n){
        set = new Sets(getWlist().get(i),getHlist().get(j),getChlist().get(k),
                    getNlist().get(l),getRlist().get(m),getBlist().get(n));

        getWlist().remove(i);
        getHlist().remove(j);
        getChlist().remove(k);
        getNlist().remove(l);
        getRlist().remove(m);
        getBlist().remove(n);

        history.add(set);

        int aIdx=0, bIdx=0,cIdx=0,dIdx=0,eIdx=0,fIdx=0;


        List<int[]> list = new ArrayList<int[]>(Arrays.asList(wInventory));
        aIdx = wInventory[i][0];
        
        list.remove(i);
        wInventory = list.toArray(new int[][]{});
        wCntr--;

        List<int[]> list1 = new ArrayList<int[]>(Arrays.asList(hInventory));
        bIdx = hInventory[j][0];
        list1.remove(j);
        hInventory = list1.toArray(new int[][]{});
        hCntr--;

        List<int[]> list2 = new ArrayList<int[]>(Arrays.asList(chInventory));
        cIdx = chInventory[k][0];
        list2.remove(k);
        chInventory = list2.toArray(new int[][]{});
        chCntr--;

        List<int[]> list3 = new ArrayList<int[]>(Arrays.asList(nInventory));
        dIdx = nInventory[l][0];
        list3.remove(l);
        nInventory = list3.toArray(new int[][]{});
        nCntr--;

        List<int[]> list4 = new ArrayList<int[]>(Arrays.asList(rInventory));
        eIdx = rInventory[m][0];
        list4.remove(m);
        rInventory = list4.toArray(new int[][]{});
        rCntr--;

        List<int[]> list5 = new ArrayList<int[]>(Arrays.asList(bInventory));
        fIdx = bInventory[n][0];
        list5.remove(n);
        bInventory = list5.toArray(new int[][]{});
        bCntr--;

        List<String[]> strlist = new ArrayList<String[]>(Arrays.asList(strInventory));
        for(int cnt=0; cnt<strCntr;cnt++){
            String s = strlist.get(cnt)[2];
            if(s.equals("W"+aIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
            else if(s.equals("H"+bIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
            else if(s.equals("Ch"+cIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
            else if(s.equals("N"+dIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
            else if(s.equals("R"+eIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
            else if(s.equals("B"+fIdx)){
                strlist.remove(cnt);
                strCntr--;
            }
        }
        strInventory = strlist.toArray(new String[][]{});

        return set;
    }


    public void loadHeros(String heroFile) {

        String[] token = heroFile.split("\\s+");
        String txt = "";
        heroNames = new String[token.length/9];
        heroStats = new int[token.length/9][8];

        for (int i = 0; i < token.length / 9; i++) {
            for (int j = 0; j < 9; j++) {
                txt = token[i * 9 + j];
                if (j == 0) {
                    heroNames[i]=txt;
                } 
                else {
                    heroStats[i][j-1]=Integer.parseInt(txt);
                }
            }
        }
    }
    //String name,int atk, int def, int hp, int spd, int crit, int critdmg, int eff, int effres
    public synchronized void convertHeroArr2List(){
        for(int i=0;i<heroNames.length;i++){
            heros.add(new Hero(heroNames[i],heroStats[i][0],heroStats[i][1],
                heroStats[i][2],heroStats[i][3],heroStats[i][4],
                heroStats[i][5],heroStats[i][6],heroStats[i][7]
                ));
        }
    }

    public synchronized void convertArray2List(int[][] arr, String[][] nameArr,String type){
        
        String[][] tmp;
        int startIdx=0;
        int endIdx=0;
        boolean first=true;
        for(int a=0;a<nameArr.length;a++){
            if(nameArr[a][2].contains(type)){
                if (first){
                    startIdx=a;
                    first=false;
                }
                endIdx=a;
            }
        }
        //subset array 
        tmp = Arrays.copyOfRange(nameArr, startIdx, endIdx+1);
        

        for(int i=0;i<arr.length;i++){
            if(type.equals("W")){
                wlist.add(new Weapon(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            else if(type.equals("H")){
                hlist.add(new Head(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            else if(type.equals("Ch")){
                chlist.add(new Chest(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            else if(type.equals("N")){
                nlist.add(new Necklace(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            else if(type.equals("R")){
                rlist.add(new Ring(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            else if(type.equals("B")){
                blist.add(new Boot(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            
        }
        
    }

    
    public synchronized  void loadInventory(String file) {

        int wcnt = countSubstr(file,"weapon");
        int hcnt = countSubstr(file,"head");
        int chcnt = countSubstr(file,"chest");
        int ncnt = countSubstr(file,"neck");
        int rcnt = countSubstr(file,"ring");
        int bcnt = countSubstr(file,"boot");

        String[] token = file.split("\\s+");
        
        String txt = "";
        String type = "";

        //int f_atk = 0, f_def = 0, f_hp = 0, p_atk = 0, p_def = 0, p_hp = 0, c = 0, cd = 0, spd = 0, eff = 0, effres = 0;
        
        int row = Utilsv1.parseInt(token[0]);
        int column = Utilsv1.parseInt(token[1]);

        wInventory = new int[wcnt][column];
        hInventory = new int[hcnt][column];
        chInventory = new int[chcnt][column];
        nInventory = new int[ncnt][column];
        rInventory = new int[rcnt][column];
        bInventory = new int[bcnt][column];

        wCntr = 0;
        hCntr = 0;
        chCntr = 0;
        nCntr = 0;
        rCntr = 0;
        bCntr = 0;
        strCntr = 0;

        strInventory = new String[row][3];
        for (int x = 0; x < row; x++) {
            type=token[(x * column  + 2)];
            for (int y = 0; y < column; y++) {
                txt = token[(x * column + y + 2)];
                
                if (y == 0 || y==12) {
                    if(y==0){
                        strInventory[strCntr][0] = txt;
                        if(type.equals("weapon")){
                            wInventory[wCntr][y]=wCntr;
                        }
                        else if(type.equals("head")){
                            hInventory[hCntr][y]=hCntr;
                        }
                        else if(type.equals("chest")){
                            chInventory[chCntr][y]=chCntr;
                        }
                        else if(type.equals("neck")){
                            nInventory[nCntr][y]=nCntr;
                        }
                        else if(type.equals("ring")){
                            rInventory[rCntr][y]=rCntr;
                        }
                        else if(type.equals("boot")){
                            bInventory[bCntr][y]=bCntr;
                        }
                    }
                    else {
                        strInventory[strCntr][1] = txt;
                        
                    
                        if(type.equals("weapon")){
                            strInventory[strCntr][2] = "W"+wCntr;
                            wCntr++;
                        }
                        else if (type.equals("head")){
                            strInventory[strCntr][2] = "H"+hCntr;
                            hCntr++;
                        }
                        else if (type.equals("chest")){
                            strInventory[strCntr][2] = "Ch"+chCntr;
                            chCntr++;
                        }
                        else if (type.equals("neck")){
                            strInventory[strCntr][2] = "N"+nCntr;
                            nCntr++;
                        }
                        else if (type.equals("ring")){
                            strInventory[strCntr][2] = "R"+rCntr;
                            rCntr++;
                        }
                        else if (type.equals("boot")){
                            strInventory[strCntr][2] = "B"+bCntr;
                            bCntr++;
                        }
                        strCntr++;
                    }
                    
                } else if(type.equals("weapon")){
                    wInventory[wCntr][y] = Utilsv1.parseInt(txt);
                } 
                else if(type.equals("head")){
                    hInventory[hCntr][y] = Utilsv1.parseInt(txt);
                } 
                else if(type.equals("chest")){
                    chInventory[chCntr][y] = Utilsv1.parseInt(txt);
                } 
                else if(type.equals("neck")){
                    nInventory[nCntr][y] = Utilsv1.parseInt(txt);
                } 
                else if(type.equals("ring")){
                    rInventory[rCntr][y] = Utilsv1.parseInt(txt);
                } 
                else if(type.equals("boot")){
                    bInventory[bCntr][y] = Utilsv1.parseInt(txt);
                } 
            }
        }
    }

    private int countSubstr(String str, String substr){
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(substr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += substr.length();
            }
        }
        return count;
    }


    public String[] getHeroNames() {
        return this.heroNames;
    }

    public void setHeroNames(String[] heroNames) {
        this.heroNames = heroNames;
    }

    public String[][] getStrInventory() {
        return this.strInventory;
    }

    public void setStrInventory(String[][] strInventory) {
        this.strInventory = strInventory;
    }

    public int[][] getHeroStats() {
        return this.heroStats;
    }

    public void setHeroStats(int[][] heroStats) {
        this.heroStats = heroStats;
    }

    public int[][] getWInventory() {
        return this.wInventory;
    }

    public void setWInventory(int[][] wInventory) {
        this.wInventory = wInventory;
    }

    public int[][] getHInventory() {
        return this.hInventory;
    }

    public void setHInventory(int[][] hInventory) {
        this.hInventory = hInventory;
    }

    public int[][] getChInventory() {
        return this.chInventory;
    }

    public void setChInventory(int[][] chInventory) {
        this.chInventory = chInventory;
    }

    public int[][] getNInventory() {
        return this.nInventory;
    }

    public void setNInventory(int[][] nInventory) {
        this.nInventory = nInventory;
    }

    public int[][] getRInventory() {
        return this.rInventory;
    }

    public void setRInventory(int[][] rInventory) {
        this.rInventory = rInventory;
    }

    public int[][] getBInventory() {
        return this.bInventory;
    }

    public void setBInventory(int[][] bInventory) {
        this.bInventory = bInventory;
    }

    public ArrayList<Equipment> getWlist() {
        return this.wlist;
    }

    public void setWlist(ArrayList<Equipment> wlist) {
        this.wlist = wlist;
    }

    public ArrayList<Equipment> getHlist() {
        return this.hlist;
    }

    public void setHlist(ArrayList<Equipment> hlist) {
        this.hlist = hlist;
    }

    public ArrayList<Equipment> getChlist() {
        return this.chlist;
    }

    public void setChlist(ArrayList<Equipment> chlist) {
        this.chlist = chlist;
    }

    public ArrayList<Equipment> getNlist() {
        return this.nlist;
    }

    public void setNlist(ArrayList<Equipment> nlist) {
        this.nlist = nlist;
    }

    public ArrayList<Equipment> getRlist() {
        return this.rlist;
    }

    public void setRlist(ArrayList<Equipment> rlist) {
        this.rlist = rlist;
    }

    public ArrayList<Equipment> getBlist() {
        return this.blist;
    }

    public void setBlist(ArrayList<Equipment> blist) {
        this.blist = blist;
    }

    public ArrayList<Hero> getHeros() {
        return this.heros;
    }

    public void setHeros(ArrayList<Hero> heros) {
        this.heros = heros;
    }
    
}