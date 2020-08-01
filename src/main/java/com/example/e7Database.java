package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//to do
//delete tables when app is closed x 
//import heros x
//create new Run Calcs using cross join + heros
//test on dyno
import java.util.Set;

public class e7Database {
    
    Connection c = null;
    Statement stmt = null;
    String host = "jdbc:postgresql://localhost/postgres"; //jdbc:postgresql://ec2-50-19-26-235.compute-1.amazonaws.com:5432/d1f9ksgsc8smsh
    String user = "postgres"; //ahlrzqrzwvftph
    String pass = "admin"; //051a15a1ce433d77db512e3d029b2706ae280bc70d93f66758351786aaec9c38
    
    public void runCalcs(String wtbl, String htbl, String chtbl, String ntbl, String rtbl, String btbl, Set<String> order){
        try{
            Calculator calc = new Calculator(wtbl,htbl,chtbl,ntbl,rtbl,btbl,order);

            c = DriverManager.getConnection(host, user, pass);
            String sql = calc.enrichSQL();
            Statement  st = c.createStatement();
            st.executeUpdate(sql);
            st.close();

            st = c.createStatement();
            st.executeUpdate(calc.calcsSQL());
            // while (rs.next()){
            //     System.out.print("Max Atk");
            //     System.out.println("w"+rs.getInt(1)+"h"+rs.getInt(2)+"c"+rs.getInt(3)+"n"+rs.getInt(4)+"r"+rs.getInt(5)+"b"+rs.getInt(6));
            // }
            // rs.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("couldn't run calc");

        }
    }

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
    public void dropTable(String tbl){
        try{
            c = DriverManager.getConnection(host, user, pass);
            String SQL = "Drop Table "+tbl;
            PreparedStatement st = c.prepareStatement(SQL);
            st.execute();
            st.close();
        }
        catch(Exception e){
            System.out.println("couldn't delete from table "+tbl);
        }
    }
    public void insertHeros(ArrayList<Hero> hero, String tbl){
        try{
            c = DriverManager.getConnection(host, user, pass);
            for(int i=0; i<hero.size();i++){
                
                String SQL = "Insert into " + tbl + 
                    "(name1, atk,def,hp,spd,crit,critdmg,eff,effres) " +
                    "Values "+
                    "("+
                        "\'"+hero.get(i).getName()+"\',"+
                        hero.get(i).getAtk()+","+
                        hero.get(i).getDef()+","+
                        hero.get(i).getHp()+","+
                        hero.get(i).getSpd()+","+
                        hero.get(i).getCrit()+","+
                        hero.get(i).getCritdmg()+","+
                        hero.get(i).getEff()+","+
                        hero.get(i).getEffres()
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
            e.printStackTrace();
        }
    }
    public void insertBag(ArrayList<Equipment> equip,String tbl,String[] set,String type){
        try{
            c = DriverManager.getConnection(host, user, pass);
            for(int i=0; i<equip.size();i++){
                
                String SQL = "Insert into " + tbl + 
                    "("+type+"pk, "+type+"id,"+type+"f_atk,"+type+"f_def,"+type+"f_hp,"+type+"p_atk,"+type+"p_def,"+type+"p_hp, "+type+"c,"+type+"cd, "+type+"spd,"+type+"eff, "+type+"effres, "+type+"setType) "+
                    " Values "+
                    " ("+
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
                        equip.get(i).getEffres()+","+
                        "\'"+set[i]+"\'"
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
    public void createHeroTable(String tname){
        try{
            c = DriverManager.getConnection( host,user, pass);
    
            System.out.println("Database Connected ..");

            String CreateSql = "Create Table " + tname + "(name1 VARCHAR, atk DOUBLE PRECISION, def DOUBLE PRECISION,hp DOUBLE PRECISION,spd DOUBLE PRECISION,crit DOUBLE PRECISION,critdmg DOUBLE PRECISION,eff DOUBLE PRECISION,effres DOUBLE PRECISION) ";
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
    public void createTable(String tname,  String type){
        try{
            c = DriverManager.getConnection( host,user, pass);
    
            System.out.println("Database Connected ..");

            String CreateSql = "Create Table " + tname + "("+type+"pk INT, "+type+"id INT ,"+type+"f_atk DOUBLE PRECISION,"+type+"f_def DOUBLE PRECISION,"+type+"f_hp DOUBLE PRECISION,"+type+"p_atk DOUBLE PRECISION,"+type+"p_def DOUBLE PRECISION,"+type+"p_hp DOUBLE PRECISION, "+type+"c DOUBLE PRECISION,"+type+"cd DOUBLE PRECISION, "+type+"spd DOUBLE PRECISION,"+type+"eff DOUBLE PRECISION, "+type+"effres DOUBLE PRECISION, "+type+"setType VARCHAR) ";
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