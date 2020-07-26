package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class e7Database {
    
    Connection c = null;
    Statement stmt = null;
    String host = "jdbc:postgresql://localhost/postgres"; //jdbc:postgresql://ec2-50-19-26-235.compute-1.amazonaws.com:5432/d1f9ksgsc8smsh
    String user = "postgres"; //ahlrzqrzwvftph
    String pass = "admin"; //051a15a1ce433d77db512e3d029b2706ae280bc70d93f66758351786aaec9c38
    
    public void clearBag(String tbl){
        try{
            c = DriverManager.getConnection(host, user, pass);
            String SQL = "Delete from "+tbl;
            PreparedStatement st = c.prepareStatement(SQL);
            st.execute();
            st.close();
        }
        catch(Exception e){
            System.out.println("couldn't delete from table "+tbl);
        }
    }
    public void insertBag(ArrayList<Equipment> equip,String tbl){
        try{
            c = DriverManager.getConnection(host, user, pass);
            for(int i=0; i<equip.size();i++){
                
                String SQL = "Insert into " + tbl + 
                    "(pk, id,f_atk,f_def,f_hp,p_atk,p_def,p_hp, c,cd, spd,eff, effres) " +
                    "Values "+
                    "("+
                        equip.get(i).getPk()+","+
                        equip.get(i).getId()+","+
                        equip.get(i).getF_atk()+","+
                        equip.get(i).getF_def()+","+
                        equip.get(i).getF_hp()+","+
                        equip.get(i).getP_atk()+","+
                        equip.get(i).getP_def()+","+
                        equip.get(i).getP_hp()+","+
                        equip.get(i).getC()+","+
                        equip.get(i).getCd()+","+
                        equip.get(i).getSpd()+","+
                        equip.get(i).getEff()+","+
                        equip.get(i).getEffres()
                    +")"
                ;
                //System.out.println(SQL);
                PreparedStatement st = c.prepareStatement(SQL);
                

                st.execute();
                st.close();
            }
            
            c.close(); 
        }
        catch(Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            //System.exit(0);
        }
    }
    public void createTable(String tname){
        try{
            c = DriverManager.getConnection( host,user, pass);
    
            System.out.println("Database Connected ..");

            String CreateSql = "Create Table " + tname + "( pk int, id int, f_atk DOUBLE PRECISION, f_def DOUBLE PRECISION, f_hp DOUBLE PRECISION, p_atk DOUBLE PRECISION, p_def DOUBLE PRECISION, p_hp DOUBLE PRECISION, c DOUBLE PRECISION, cd DOUBLE PRECISION, spd DOUBLE PRECISION, eff DOUBLE PRECISION, effres DOUBLE PRECISION) ";
            stmt = c.createStatement();
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        }
    
        catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            //System.exit(0);
        }
        System.out.println("Table Created successfully");
    
    }
    
    

}