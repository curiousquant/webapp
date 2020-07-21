package com.example;

import java.util.ArrayList;
import java.util.Arrays;

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
    public Bagv2(){

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
                    heroStats[i][j]=Integer.parseInt(txt);
                }
            }
        }
    }

    public synchronized ArrayList<Equipment> convertArray2List(int[][] arr, String[][] nameArr,String type){
        ArrayList<Equipment> list = new ArrayList<>();
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
                list.add(new Weapon(
                    arr[i][0],arr[i][0]+1,arr[i][1],arr[i][2],arr[i][3],arr[i][4], arr[i][5], 
                    arr[i][6], arr[i][7], arr[i][8], arr[i][9],arr[i][10],arr[i][11],tmp[i][1]
                ));

            }
            
        }
        return list;
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
        
        int row = Utils.parseInt(token[0]);
        int column = Utils.parseInt(token[1]);

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
                    wInventory[wCntr][y] = Utils.parseInt(txt);
                } 
                else if(type.equals("head")){
                    hInventory[hCntr][y] = Utils.parseInt(txt);
                } 
                else if(type.equals("chest")){
                    chInventory[chCntr][y] = Utils.parseInt(txt);
                } 
                else if(type.equals("neck")){
                    nInventory[nCntr][y] = Utils.parseInt(txt);
                } 
                else if(type.equals("ring")){
                    rInventory[rCntr][y] = Utils.parseInt(txt);
                } 
                else if(type.equals("boot")){
                    bInventory[bCntr][y] = Utils.parseInt(txt);
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
    
}