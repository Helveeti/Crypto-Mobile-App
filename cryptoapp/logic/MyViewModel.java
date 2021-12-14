package com.example.cryptoapp.logic;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyViewModel extends AndroidViewModel {
    private static final String DEBUG_TAG = "MyModelView: ";
    private long startDate, endDate;

    private BitcoinHandler handler;

    public MyViewModel (Application application) {
        super(application);
        handler = new BitcoinHandler();
    }

    public void loadResult() {
        handler.loadResult();
    }

    public String getResult(){
        return handler.getResult(); }

    public void insert(Bitcoin c) { handler.insert(c); }

    public void setStartDate(String startDate) throws ParseException {
        if(!startDate.isEmpty()) {
            startDate = startDate.replaceAll("[. ]", "");
            Date start = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH).parse(startDate + "0000");
            assert start != null;
            this.startDate = start.getTime() / 1000;
        }
    }

    public void setEndDate(String endDate) throws ParseException {
        if(!endDate.isEmpty()) {
            endDate = endDate.replaceAll("[. ]", "");
            Date end = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH).parse(endDate + "0000");
            assert end != null;
            this.endDate = end.getTime() / 1000;
        }
    }

    public long getStartDate(){ return startDate; }
    public long getEndDate(){ return endDate; }
}
