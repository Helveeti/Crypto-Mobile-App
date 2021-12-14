package com.example.cryptoapp.logic;

import java.util.Date;

public class Bitcoin {

    private int id;

    private String unixDate;

    private String normalDate;

    private Date date;

    private double price;

    public Bitcoin(String unixDate, double price){
        this.unixDate = unixDate;
        this.price = price;
        this.date = new Date (Long.parseLong(unixDate)*1000);
        this.normalDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);
    }

    public void setUnixDate(String unixDate){ this.unixDate = unixDate; }
    public void setPrice(double price){ this.price = price; }
    public void setId(int id){ this.id = id; }
    public void setNormalDate(String date){ this.normalDate = date; }
    public void setDate(Date date){ this.date = date; }

    public String getUnixDate(){ return unixDate; }
    public double getPrice(){ return price; }
    public int getId(){ return id; }
    public String getNormalDate(){ return normalDate; }
    public Date getDate(){ return date; }

    public String toString(){
        return "Date: " + normalDate + " Price: " + price;
    }

}
