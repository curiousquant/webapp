
package com.example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.ui.Notification;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
        
        final Grid<Equipment> grid = new Grid<>();
        grid.setWidth("1000px");
        final Grid<Equipment> statGrid = new Grid<>();
        statGrid.setWidth("1000px");
        Bag b = new Bag();
        setSizeFull();

        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        final Upload upload = new Upload(multiFileMemoryBuffer);
        upload.addFinishedListener(e -> {
            
            InputStream inputStreamBag = multiFileMemoryBuffer.getInputStream("bag.txt");
            InputStream inputStreamHero = multiFileMemoryBuffer.getInputStream("heroBag.txt");
            // read the contents of the buffered memory
            // from inputStream
            try{
                String bag = IOUtils.toString(inputStreamBag, StandardCharsets.UTF_8);
                if(bag.length()>1){
                    b.loadInventory(bag);
                    ArrayList<Equipment> tmp = new ArrayList<>();
                    tmp.addAll(b.getW());
                    tmp.addAll(b.getH());
                    tmp.addAll(b.getCh());
                    tmp.addAll(b.getN());
                    tmp.addAll(b.getR());
                    tmp.addAll(b.getB());

                    grid.setItems(tmp);
                }
                
                String heroBag = IOUtils.toString(inputStreamHero, StandardCharsets.UTF_8);
                if(heroBag.length()>1){
                    b.loadHeros(heroBag);
                    
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }

        });

        
        
        //grid.addColumn(Equipment::getPk).setHeader("pk");
        grid.addColumn(Equipment::getId).setHeader("id");
        grid.addColumn(Equipment::getF_atk).setHeader("flat atk");
        grid.addColumn(Equipment::getF_def).setHeader("flat def");
        grid.addColumn(Equipment::getF_hp).setHeader("flat hp");
        grid.addColumn(Equipment::getP_atk).setHeader("% atk");
        grid.addColumn(Equipment::getP_def).setHeader("% def");
        grid.addColumn(Equipment::getP_hp).setHeader("% hp");
        grid.addColumn(Equipment::getC).setHeader("crit chance");
        grid.addColumn(Equipment::getCd).setHeader("crit dmg");
        grid.addColumn(Equipment::getSpd).setHeader("speed");
        grid.addColumn(Equipment::getEff).setHeader("effect");
        grid.addColumn(Equipment::getEffres).setHeader("effect resis");
        grid.addColumn(Equipment::getSet).setHeader("set");

        add(grid,upload);
        
        statGrid.addColumn(Equipment::getId).setHeader("id");
        statGrid.addColumn(Equipment::getF_atk).setHeader("flat atk");
        statGrid.addColumn(Equipment::getF_def).setHeader("flat def");
        statGrid.addColumn(Equipment::getF_hp).setHeader("flat hp");
        statGrid.addColumn(Equipment::getP_atk).setHeader("% atk");
        statGrid.addColumn(Equipment::getP_def).setHeader("% def");
        statGrid.addColumn(Equipment::getP_hp).setHeader("% hp");
        statGrid.addColumn(Equipment::getC).setHeader("crit chance");
        statGrid.addColumn(Equipment::getCd).setHeader("crit dmg");
        statGrid.addColumn(Equipment::getSpd).setHeader("speed");
        statGrid.addColumn(Equipment::getEff).setHeader("effect");
        statGrid.addColumn(Equipment::getEffres).setHeader("effect resis");
        statGrid.addColumn(Equipment::getSet).setHeader("set");
        add(statGrid);
        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Run Calcs",
        e -> {
            Sets s = b.superCalcs(b.getW(), b.getH(), b.getCh(), b.getN(), b.getR(), b.getB());
            ArrayList<Equipment> tmp = new ArrayList<>();
            tmp.add(s.getWeapon());
            tmp.add(s.getHead());
            tmp.add(s.getChest());
            tmp.add(s.getNeck());
            tmp.add(s.getRing());
            tmp.add(s.getBoot());
            
            
            statGrid.setItems(tmp);
            
            
            }
        
        );

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(button);

        




        TextField test = new TextField("Your name");
        test.addThemeName("bordered");
        // Use TextField for standard text input
        TextField textField = new TextField("Your name");
        textField.addThemeName("bordered");

       
        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        //button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        //button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        //addClassName("centered-content");

        //\add(textField, button,test);

    }

}
