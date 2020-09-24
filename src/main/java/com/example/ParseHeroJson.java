package com.example;

import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;


public class ParseHeroJson {
    final static int SKILLCNT = 3,GRADE = 6, LEVEL = 60;
    final static String[] SKILLATTRIBUTE = {"name","pow","att_rate","cooldown"};
    final String FILEPATH = "hero";
    
    public EquippedHero readHeroStats(String name,Sets set){
       
        try {
            Path path = FileSystems.getDefault().getPath(FILEPATH, name);
            String content = Files.readString(path);
            JSONObject jo = new JSONObject(content);
            HashMap<String,String> skills = new HashMap<String,String>();
            HashMap<String,Double> stats = new HashMap<String,Double>();

            
            //get hero information
            JSONArray keys = jo.getJSONObject("stats").names();
            for(int i=0; i<keys.length();i++){
                stats.put(keys.get(i).toString(),Double.parseDouble(String.valueOf(jo.getJSONObject("stats").get(keys.get(i).toString()))));
            }
            // BASE FORMULA:
            // HP: `(50 + INT * 1.4) * (LEVEL / 3 + 1) * (1 + (GRADE - 1) * 0.075)`
            // ATK: `(BRA * 0.6 * (LEVEL / 6 + 1) * (1 + (GRADE - 1) * 0.075)`
            // DEF: `(30 + FAI* 0.3) * (LEVEL / 8 + 1) * (1 + (GRADE - 1) * 0.075)`
            // SPD: `60 + DES / 1.6`
            double hp = (50.0+stats.get("int")*1.4)*((double)(LEVEL)/3+1)*(1+(double)(GRADE-1)*0.075);
            double atk = stats.get("bra")*0.6*((double)LEVEL/6+1)*(1+((double)GRADE-1)*.075);
            double def = (30+ stats.get("fai")*.3)*((double)LEVEL/8+1)*(1+((double)GRADE-1)*.075);
            double spd = 60 + stats.get("des")/1.6;
            double eff = 0;
            double effres = 0;
            double crit = 15;
            double cd = 150;
            //get skill information
            for(int i=0; i<SKILLCNT;i++){
                for(int j=0;j<SKILLATTRIBUTE.length;j++){
                    skills.put(SKILLATTRIBUTE[j]+i, jo.getJSONArray("skills").getJSONObject(i).get(SKILLATTRIBUTE[j]).toString());
                }
            }
            
            EquippedHero h = new EquippedHero(name.split(".json")[0],atk,def,hp,spd,crit,cd,eff,effres,
                                                skills,set,Integer.parseInt(skills.get("cooldown"+0)),Integer.parseInt(skills.get("cooldown"+1)),Integer.parseInt(skills.get("cooldown"+2)));
            return h;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        ParseHeroJson p = new ParseHeroJson();
        Equipment weapon = new Weapon(0,1,500,0,0,9,0,8,8,0,13,0,0,"life");
        Equipment head= new Head(0,1,0,0,2700,8,0,25,11,0,2,0,0,"life");
        Equipment chest= new Chest(0,1,0,300,0,0,0,13,4,0,12,10,0,"life");
        Equipment neck= new Necklace(0,1,0,0,0,50,0,14,6,0,6,12,0,"life");
        Equipment ring= new Ring(0,1,0,0,0,50,0,11,7,0,5,10,0,"life");
        Equipment boot= new Boot(0,1,0,0,0,60,0,8,7,0,7,14,0,"life");
        Sets s = new Sets(weapon,head,chest,neck,ring,boot);
        p.readHeroStats("tenebria.json",s);
    }
}