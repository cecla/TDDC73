package com.example.cecilialagerwall.labb2;

import java.util.ArrayList;

/**
 * Created by cecilialagerwall on 2016-11-23.
 */

public class Parent {

    private String name;
    private ArrayList<Child> childList;

    public Parent(String name, ArrayList<Child> childList) {
        this.name = name;
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Child> getChildList() {
        return childList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildList(ArrayList<Child> childList) {
        this.childList = childList;
    }
}