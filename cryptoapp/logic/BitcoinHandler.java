package com.example.cryptoapp.logic;

import android.util.Log;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BitcoinHandler {
    private static final String DEBUG = "BitcoinHandler:";
    private List<Bitcoin> list;
    private String result = "";

    public BitcoinHandler(){
        list = new ArrayList<Bitcoin>();
    }

    public void insert(Bitcoin coin) {
        list.add(coin);
    }

    public String getResult(){
        return result;
    }
    public void loadResult() { getResultList(); }

    private Date getCalendar(Date date, boolean last){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        if(last) cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    private void getResultList(){
        Map<Integer, String> resultList = new HashMap<Integer, String>();
        Bitcoin lastOne = null;
        int index = 0;
        Date start = null,
                end = null;

        for(Bitcoin b : list){
            if(lastOne != null && b.getPrice() < lastOne.getPrice()){
                Date daTemp = getCalendar(lastOne.getDate(), true);
                Date bDate = getCalendar(b.getDate(), false);

                if(bDate.equals(daTemp)){
                    if(index == 0) start = bDate;
                    index++;
                    end = bDate;
                }
            }else{
                resultList.put(index, "Start date was: " + start + "\nEnd date was: " + end + "\n Days between: " + index);
                index = 0;
            }

            lastOne = b;
        }
        result = findMax(resultList);

    }

    private String findMax(Map<Integer, String> map){
        int maxValue = 0;
        String result = "";

        for(Map.Entry<Integer, String> h : map.entrySet()){
            if(h.getKey() > maxValue){
                maxValue = h.getKey();
                result = h.getValue();
            }
        }

        return result;
    }
}
