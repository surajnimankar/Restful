package com.restful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRollNo(){
        return rollNo;
    }

    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }

    private int rollNo;
}
