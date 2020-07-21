package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    double heroatk =1;

    ArrayList<Equipment> wlist = new ArrayList<>();
    ArrayList<Equipment> hlist = new ArrayList<>();
    ArrayList<Equipment> chlist = new ArrayList<>();
    ArrayList<Equipment> nlist = new ArrayList<>();
    ArrayList<Equipment> rlist = new ArrayList<>();
    ArrayList<Equipment> blist = new ArrayList<>();

    ArrayList<Sets> history = new ArrayList<>();
    Sets set = new Sets();
    public Bagv2(){

    }
 //int pk int f_atk = 0, f_def = 0, f_hp = 0, p_atk = 0, p_def = 0, p_hp = 0, c = 0, cd = 0, spd = 0, eff = 0, effres = 0;
    public Sets runCalcs(){
        int maxI=0,maxJ=0,maxK=0,maxL=0,maxM=0,maxN=0;
        double maxAtk = 0;

        for(int i=0;i<wCntr;i++){
            for(int j=0;j<hCntr;j++){
                for(int k=0;k<chCntr;k++){
                    for(int l=0;l<nCntr;l++){
                        for(int m=0;m<rCntr;m++){
                            for(int n=0; n<bCntr;n++){
                                double atk = wInventory[i][1]+hInventory[j][1]+chInventory[k][1]
                                            +nInventory[l][1]+rInventory[m][1]+bInventory[n][1]
                                        + heroatk*(1+(wInventory[i][5]+hInventory[j][5]+chInventory[k][5]
                                            +nInventory[l][5]+rInventory[m][5]+bInventory[n][5]));
                                if(maxAtk<atk){
                                    maxAtk = atk;
                                    maxI = wInventory[i][0];
                                    maxJ = hInventory[j][0];
                                    maxK = chInventory[k][0];
                                    maxL = nInventory[l][0];
                                    maxM = rInventory[m][0];
                                    maxN = bInventory[n][0];
                                }
                            }
                        }
                    }
                }
            }
        }
        return outputSets(maxI, maxJ, maxK, maxL, maxM, maxN);
        
    }

    public Sets outputSets(int i, int j, int k, int l, int m, int n){
        set = new Sets(getWlist().get(i),getHlist().get(j),getChlist().get(k),
                    getNlist().get(l),getRlist().get(m),getBlist().get(n));
        history.add(set);
        int aIdx=0, bIdx=0,cIdx=0,dIdx=0,eIdx=0,fIdx=0;
        List<int[]> list = new ArrayList<int[]>(Arrays.asList(wInventory));
        for (int a=0;a<list.size();a++){
            if(list.get(a)[0]==i){
                list.remove(a);
                aIdx=a;
            }
        }
        wInventory = list.toArray(new int[][]{});
        wCntr--;

        List<int[]> list1 = new ArrayList<int[]>(Arrays.asList(hInventory));
        for (int a=0;a<list1.size();a++){
            if(list1.get(a)[0]==j){
                list1.remove(a);
                bIdx=a;
            }
        }
        hInventory = list1.toArray(new int[][]{});
        hCntr--;

        List<int[]> list2 = new ArrayList<int[]>(Arrays.asList(chInventory));
        for (int a=0;a<list2.size();a++){
            if(list2.get(a)[0]==k){
                list2.remove(a);
                cIdx=a;
            }
        }
        chInventory = list2.toArray(new int[][]{});
        chCntr--;

        List<int[]> list3 = new ArrayList<int[]>(Arrays.asList(nInventory));
        for (int a=0;a<list3.size();a++){
            if(list3.get(a)[0]==l){
                list3.remove(a);
                dIdx=a;
            }
        }
        nInventory = list3.toArray(new int[][]{});
        nCntr--;

        List<int[]> list4 = new ArrayList<int[]>(Arrays.asList(rInventory));
        for (int a=0;a<list4.size();a++){
            if(list4.get(a)[0]==m){
                list4.remove(a);
                eIdx=a;
            }
        }
        rInventory = list4.toArray(new int[][]{});
        rCntr--;

        List<int[]> list5 = new ArrayList<int[]>(Arrays.asList(bInventory));
        for (int a=0;a<list5.size();a++){
            if(list5.get(a)[0]==n){
                list5.remove(a);
                fIdx=a;
            }
        }
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
                    heroStats[i][j]=Integer.parseInt(txt);
                }
            }
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
    
}