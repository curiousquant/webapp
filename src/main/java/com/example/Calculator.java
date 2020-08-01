package com.example;

import java.util.Set;
import java.util.StringJoiner;

public class Calculator {
    String wtbl, htbl, ctbl, ntbl, rtbl, btbl;
    Set<String> order;
    public Calculator(String wtbl, String htbl, String ctbl, String ntbl, String rtbl, String btbl, Set<String> order){
        this.wtbl = wtbl;
        this.htbl = htbl;
        this.ctbl = ctbl;
        this.ntbl = ntbl;
        this.rtbl = rtbl;
        this.btbl = btbl;
        this.order = order;
    }

    public String enrichSQL(){
        String sql = 
       " select *, "+
       "     case "+
       "         when w.wsettype =  'atk' then 1"+
       "         else 0"+
       "     end as watkset,"+
       "     case "+
       "         when w.wsettype =  'def' then 1"+
       "         else 0"+
       "     end as wdefset,"+
       "     case "+
       "         when w.wsettype =  'hp' then 1"+
       "         else 0"+
       "     end as whpset,"+
       "     case "+
       "         when w.wsettype =  'eff' then 1"+
       "         else 0"+
       "     end as weffset,"+
       "     case "+
       "         when w.wsettype =  'spd' then 1"+
       "         else 0"+
       "     end as wspdset,"+
       "     case "+
       "         when w.wsettype =  'crit' then 1"+
       "         else 0"+
       "     end as wcset,"+
       "     case "+
       "         when w.wsettype =  'dest' then 1"+
       "         else 0"+
       "     end as wcdset"+
       "     into  public.tmp"+wtbl+" from  "+wtbl+" as w order by "+concatStr(order,"w")+"  limit 5;"+
       " select *, "+
       "     case "+
       "         when h.hsettype =  'atk' then 1"+
       "         else 0"+
       "     end as hatkset,"+
       "     case "+
       "         when h.hsettype =  'def' then 1"+
       "         else 0"+
       "     end as hdefset,"+
       "     case "+
       "         when h.hsettype =  'hp' then 1"+
       "         else 0"+
       "     end as hhpset,"+
       "     case "+
       "         when h.hsettype =  'eff' then 1"+
       "         else 0"+
       "     end as heffset,"+
       "     case "+
       "         when h.hsettype =  'spd' then 1"+
       "         else 0"+
       "     end as hspdset,"+
       "     case "+
       "         when h.hsettype =  'crit' then 1"+
       "         else 0"+
       "     end as hcset,"+
       "     case "+
       "         when h.hsettype =  'cd' then 1"+
       "         else 0"+
       "     end as hcdset"+
       "     into  public.tmp"+htbl+" from  "+htbl+" as h order by "+concatStr(order,"h")+"  limit 5;"+
       " select *, "+
       "     case "+
       "         when c.csettype =  'atk' then 1"+
       "         else 0"+
       "     end as catkset,"+
       "     case "+
       "         when c.csettype =  'def' then 1"+
       "         else 0"+
       "     end as cdefset,"+
       "     case "+
       "         when c.csettype =  'hp' then 1"+
       "         else 0"+
       "     end as chpset,"+
       "     case "+
       "         when c.csettype =  'eff' then 1"+
       "         else 0"+
       "     end as ceffset,"+
       "     case "+
       "         when c.csettype =  'spd' then 1"+
       "         else 0"+
       "     end as cspdset,"+
       "     case "+
       "         when c.csettype =  'crit' then 1"+
       "         else 0"+
       "     end as ccset,"+
       "     case "+
       "         when c.csettype =  'dest' then 1"+
       "         else 0"+
       "     end as ccdset"+
       "     into  public.tmp"+ctbl+" from  "+ctbl+" as c order by "+concatStr(order,"c")+"  limit 5;"+
       " select *, "+
       "     case "+
       "         when n.nsettype =  'atk' then 1"+
       "         else 0"+
       "     end as natkset,"+
       "     case "+
       "         when n.nsettype =  'def' then 1"+
       "         else 0"+
       "     end as ndefset,"+
       "     case "+
       "         when n.nsettype =  'hp' then 1"+
       "         else 0"+
       "     end as nhpset,"+
       "     case "+
       "         when n.nsettype =  'eff' then 1"+
       "         else 0"+
       "     end as neffset,"+
       "     case "+
       "         when n.nsettype =  'spd' then 1"+
       "         else 0"+
       "     end as nspdset,"+
       "     case "+
       "         when n.nsettype =  'crit' then 1"+
       "         else 0"+
       "     end as ncset,"+
       "     case "+
       "         when n.nsettype =  'dest' then 1"+
       "         else 0"+
       "     end as ncdset"+
       "     into  public.tmp"+ntbl+" from  "+ntbl+" as n order by "+concatStr(order,"n")+"  limit 5;"+
       " select *, "+
       "     case "+
       "         when r.rsettype =  'atk' then 1"+
       "         else 0"+
       "     end as ratkset,"+
       "     case "+
       "         when r.rsettype =  'def' then 1"+
       "         else 0"+
       "     end as rdefset,"+
       "     case "+
       "         when r.rsettype =  'hp' then 1"+
       "         else 0"+
       "     end as rhpset,"+
       "     case "+
       "         when r.rsettype =  'eff' then 1"+
       "         else 0"+
       "     end as reffset,"+
       "     case "+
       "         when r.rsettype =  'spd' then 1"+
       "         else 0"+
       "     end as rspdset,"+
       "     case "+
       "         when r.rsettype =  'crit' then 1"+
       "         else 0"+
       "     end as rcset,"+
       "     case "+
       "         when r.rsettype =  'dest' then 1"+
       "         else 0"+
       "     end as rcdset"+
       "     into  public.tmp"+rtbl+" from  "+rtbl+" as r order by "+concatStr(order,"r")+"  limit 5;"+
       " select *, "+
       "     case "+
       "         when b.bsettype =  'atk' then 1"+
       "         else 0"+
       "     end as batkset,"+
       "     case "+
       "         when b.bsettype =  'def' then 1"+
       "         else 0"+
       "     end as bdefset,"+
       "     case "+
       "         when b.bsettype =  'hp' then 1"+
       "         else 0"+
       "     end as bhpset,"+
       "     case "+
       "         when b.bsettype =  'eff' then 1"+
       "         else 0"+
       "     end as beffset,"+
       "     case "+
       "         when b.bsettype =  'spd' then 1"+
       "         else 0"+
       "     end as bspdset,"+
       "     case "+
       "         when b.bsettype =  'crit' then 1"+
       "         else 0"+
       "     end as bcset,"+
       "     case "+
       "         when b.bsettype =  'dest' then 1"+
       "         else 0"+
       "     end as bcdset"+
       "     into  public.tmp"+btbl+" from  "+btbl+" as b order by "+concatStr(order,"b")+"  limit 5;"
        ;
        System.out.println(sql);
        return sql;
    }
    public String calcsSQL(){
        String sql = 
        
        
        "create table allResult as "+
        "select * from (select *,"+
        "    case "+
        "        when totalatkset >=4 then wp_atk + hp_atk +cp_atk + np_atk + rp_atk + bp_atk + 35"+
        "        else wp_atk + hp_atk +cp_atk + np_atk + rp_atk + bp_atk"+
        "    end as totalatkp,"+
        "    case "+
        "        when totaldefset =6 then wp_def + hp_def +cp_def + np_def + rp_def + bp_def + 15*3"+
        "        when totaldefset >=4 then wp_def + hp_def +cp_def + np_def + rp_def + bp_def + 15*2"+
        "        when totaldefset >=2 then wp_def + hp_def +cp_def + np_def + rp_def + bp_def + 15*1"+
        "        else wp_def + hp_def +cp_def + np_def + rp_def + bp_def"+
        "    end as totaldefp,"+
        "    case "+
        "        when totalhpset =6 then wp_hp + hp_hp +cp_hp + np_hp + rp_hp + bp_hp + 15*3"+
        "        when totalhpset >=4 then wp_hp + hp_hp +cp_hp + np_hp + rp_hp + bp_hp + 15*2"+
        "        when totalhpset >=2 then wp_hp + hp_hp +cp_hp + np_hp + rp_hp + bp_hp + 15*1"+
        "        else wp_hp + hp_hp +cp_hp + np_hp + rp_hp + bp_hp"+
        "    end as totalhpp,"+
        "    case "+
        "        when totalcset =6 then wc + hc +cc + nc + rc + bc + 15*3"+
        "        when totalcset >=4 then wc + hc +cc + nc + rc + bc + 15*2"+
        "        when totalcset >=2 then wc + hc +cc + nc + rc + bc + 15*1"+
        "        else wc + hc +cc + nc + rc + bc"+
        "    end as totalcritp,"+
        "    case "+
        "        when totalcdset >=4 then wcd + hcd +ccd + ncd + rcd + bcd + 25"+
        "        else wcd + hcd +ccd + ncd + rcd + bcd"+
        "    end as totalcdp,"+
        "    case "+
        "        when totaleffset =6 then weff + heff +ceff + neff + reff + beff + 15*3"+
        "        when totaleffset >=4 then weff + heff +ceff + neff + reff + beff + 15*2"+
        "        when totaleffset >=2 then weff + heff +ceff + neff + reff + beff + 15*1"+
        "        else weff + heff +ceff + neff + reff + beff"+
        "    end as totaleffp,"+
        "    case "+
        "        when totalspdset >=4 then wspd + hspd +cspd + nspd + rspd + bspd + 25"+
        "        else wspd + hspd +cspd + nspd + rspd + bspd"+
        "    end as totalspdp"+
        "    "+
        "    "+
        "    from ("+
        "        select w.*,h.*,c.*,n.*,r.*,b.*,"+
        "            w.watkset + h.hatkset +c.catkset + n.natkset + r.ratkset + b.batkset as totalatkset,"+
        "            w.wdefset + h.hdefset +c.cdefset + n.ndefset + r.rdefset + b.bdefset as totaldefset,"+
        "            w.whpset + h.hhpset +c.chpset + n.nhpset + r.rhpset + b.bhpset as totalhpset,"+
        "            w.weffset + h.heffset +c.ceffset + n.neffset + r.reffset + b.beffset as totaleffset,"+
        "            w.wspdset + h.hspdset +c.cspdset + n.nspdset + r.rspdset + b.bspdset as totalspdset,"+
        "           w.wcset + h.hcset +c.ccset + n.ncset + r.rcset + b.bcset as totalcset,"+
        "           w.wcdset + h.hcdset +c.ccdset + n.ncdset + r.rcdset + b.bcdset as totalcdset"+
        "            "+
        "        from "+
        "            tmp"+wtbl+" as w"+
        "            cross join tmp"+htbl+"   as h"+
        "            cross join tmp"+ctbl+" as c"+
        "            cross join tmp"+ntbl+"   as n"+
        "            cross join tmp"+rtbl+"   as r"+
        "            cross join tmp"+btbl+"  as b"+
        "            "+
        "        ) as tmp"+
        "    order by totalatkp"+
        "    ) as tmp2"+
        ";"+
        "drop table tmp"+wtbl+";"+
        "drop table tmp"+htbl+";"+
        "drop table tmp"+ctbl+";"+
        "drop table tmp"+ntbl+";"+
        "drop table tmp"+rtbl+";"+
        "drop table tmp"+btbl+";"
        ;
        return sql;
    }
    public String concatStr(Set<String> str, String type){
        StringJoiner joiner = new StringJoiner(",");
        if(str.contains("Atk")){
            joiner.add(type+"p_atk desc");
        }
        if(str.contains("Hp")){
            joiner.add(type+"p_hp desc");
        }
        if(str.contains("Def")){
            joiner.add(type+"p_def desc");
        }
        if(str.contains("Spd")){
            joiner.add(type+"spd desc");
        }
        if(str.contains("Crit Chance")){
            joiner.add(type+"c desc");
        }
        if(str.contains("Crit Dmg")){
            joiner.add(type+"cd desc");
        }
        if(str.contains("Eff")){
            joiner.add(type+"eff desc");
        }
        
        return joiner.toString();
    }
}