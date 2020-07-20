package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.excel.ExcelUploader;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Upload;


public class User implements Serializable {
        private int id;
        private String firstname;
        private String lastname;
        private int age;
        
    //....
    public User(int id, String firstname, String lastname, int age){
        this.id= id;
        this.firstname=firstname;
        this.lastname = lastname;
        this.age = age;
    }
    public User(){

    }
    public void test(){
        
        final Grid<User> grid = new Grid<>();
        grid.addColumn(User::getId).setCaption("ID");
        grid.addColumn(User::getFirstname).setCaption("Name");
        grid.addColumn(User::getAge).setCaption("Email");

        ExcelUploader<User> excelUploader = new ExcelUploader<>(User.class);
    
        // add option
        // excelUploader.setFirstRow(2);  // default : 0
        // excelUploader.setSheetAt(1);  // default: 0
        // excelUploader.setSheetName("Sheet2");  // Target sheetAt or SheetName
        
        excelUploader.addSucceededListener((event, items) -> {
            if(items.size()>0) {
                grid.setItems(items);
            }
        });
        
        final Upload upload = new Upload();
        upload.setButtonCaption("Upload");
        upload.setReceiver(excelUploader);
        upload.addSucceededListener(excelUploader);
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     
}