
package com.example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.StreamResource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.haijian.Exporter;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout  {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {
        
        final Grid<Equipment> grid = new Grid<>(Equipment.class);
        final Grid<Equipment> statGrid = new Grid<>(Equipment.class);
        final Grid<Hero> heroGrid = new Grid<>(Hero.class);
        final Grid<Equipment> historyGrid = new Grid<>();
        boolean isActive = false;
        Select<String> listBox = new Select<>();
        ArrayList<Equipment>out_calc = new ArrayList<>();
        
        grid.setWidth("1600px");
        statGrid.setWidth("1600px");
        heroGrid.setWidth("1600px");
        historyGrid.setWidth("1600px");
        Bagv2 b = new Bagv2();
        setSizeFull();

        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();


        listBox.addValueChangeListener(event -> {
            //if(isActive){
                Hero selectedHero = new Hero();
                for(int i=0;i<b.heros.size();i++){
                    if(b.heros.get(i).getName().equals(listBox.getValue())){
                        selectedHero = b.heros.get(i);
                    }
                }
                if(selectedHero!=null&&out_calc!=null){
                    ArrayList<Hero> h = b.calcHero(selectedHero,out_calc);
                    heroGrid.setItems(h);
                }
                
            //}
        });

        final Upload upload = new Upload(multiFileMemoryBuffer);
        upload.addFinishedListener(e -> {
            
            InputStream inputStreamBag = multiFileMemoryBuffer.getInputStream("bag.txt");
            InputStream inputStreamHero = multiFileMemoryBuffer.getInputStream("heroBag.txt");
            // read the contents of the buffered memory
            // from inputStream
            try{
                String bag = IOUtils.toString(inputStreamBag, StandardCharsets.UTF_8);
                //System.out.println(bag);
                if(bag.length()>1){
                    b.loadInventory(bag);
                    b.convertArray2List(b.wInventory,b.strInventory,"W");b.convertArray2List(b.hInventory,b.strInventory,"H");
                    b.convertArray2List(b.chInventory,b.strInventory,"Ch");b.convertArray2List(b.nInventory,b.strInventory,"N");
                    b.convertArray2List(b.rInventory,b.strInventory,"R");b.convertArray2List(b.bInventory,b.strInventory,"B");

                    ArrayList<Equipment> tmp = b.getWlist();
                    
                    tmp.addAll( b.getHlist());tmp.addAll( b.getChlist());
                    tmp.addAll( b.getNlist());tmp.addAll( b.getRlist());
                    tmp.addAll( b.getBlist());
                    
                    //grid.setItems(tmp);
                }
                
                String heroBag = IOUtils.toString(inputStreamHero, StandardCharsets.UTF_8);
                if(heroBag.length()>1){
                    b.loadHeros(heroBag);
                    b.convertHeroArr2List();
                    //heroGrid.setItems(b.heros);
                    String[] hnames = new String[b.heros.size()];
                    for(int i=0;i<b.heros.size();i++){
                        hnames[i] = b.heros.get(i).getName();
                    }
                    
                    listBox.setItems(hnames);
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }

        });

        

        historyGrid.addColumn(Equipment::getId).setHeader("id").setKey("id");
        historyGrid.addColumn(Equipment::getF_atk).setHeader("flat atk").setKey("f_atk");
        historyGrid.addColumn(Equipment::getF_def).setHeader("flat def").setKey("f_def");
        historyGrid.addColumn(Equipment::getF_hp).setHeader("flat hp").setKey("f_hp");
        historyGrid.addColumn(Equipment::getP_atk).setHeader("% atk").setKey("p_atk");
        historyGrid.addColumn(Equipment::getP_def).setHeader("% def").setKey("p_def");
        historyGrid.addColumn(Equipment::getP_hp).setHeader("% hp").setKey("p_hp");
        historyGrid.addColumn(Equipment::getC).setHeader("crit chance").setKey("c");
        historyGrid.addColumn(Equipment::getCd).setHeader("crit dmg").setKey("cd");
        historyGrid.addColumn(Equipment::getSpd).setHeader("speed").setKey("spd");
        historyGrid.addColumn(Equipment::getEff).setHeader("effect").setKey("eff");
        historyGrid.addColumn(Equipment::getEffres).setHeader("effect resis").setKey("effres");
        historyGrid.addColumn(Equipment::getSet).setHeader("set").setKey("set");
        
        Anchor a = new Anchor(new StreamResource("my-excel.xlsx", Exporter.exportAsExcel(historyGrid)), "Download As Excel");
        add(listBox,upload,statGrid,heroGrid,a);
        
        Button button = new Button("Run Calcs",
        e -> {
                out_calc.clear();
                Hero selectedHero = new Hero();
                for(int i=0;i<b.heros.size();i++){
                    if(b.heros.get(i).getName().equals(listBox.getValue())){
                        selectedHero = b.heros.get(i);
                    }
                }
                Sets s = b.runCalcs(selectedHero);
                
                out_calc.add(s.getWeapon()); out_calc.add(s.getHead());out_calc.add(s.getChest());
                out_calc.add(s.getNeck());out_calc.add(s.getRing());out_calc.add(s.getBoot());
                
                statGrid.setItems(out_calc);
                
                ArrayList<Hero> h = b.calcHero(selectedHero,out_calc);

                ArrayList<Equipment> tmp1 = new ArrayList<>();
                for(int i=0;i<b.history.size();i++){
                    Sets set = b.history.get(i);

                    tmp1.add( set.getWeapon());tmp1.add( set.getHead());tmp1.add( set.getChest());
                    tmp1.add( set.getNeck());tmp1.add( set.getRing());tmp1.add( set.getBoot());
                }
        
                heroGrid.setItems(h);
                historyGrid.setItems(tmp1);
            }
        
         );
         button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
         add(button);


    }

   
}
