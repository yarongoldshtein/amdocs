package com.example.amdocs;

import java.util.*;

public class DataMock {
    private List<Data> allOrders = new ArrayList<>();
    public DataMock() {
        allOrders.add(new Data(1, "dsc", "yaron", "gold", "yaron.goldshtein@gmail.com", "266$",  new GregorianCalendar(1990, Calendar.SEPTEMBER, 05).getTime(), "status"));
        allOrders.add(new Data(2, "dsc1", "Efi", "Bla", "blaBlan@gmail.com", "35$",  new GregorianCalendar(2017, Calendar.MAY, 15).getTime(), "status nice"));
        allOrders.add(new Data(3, "dsc2", "Roi", "Zis", "zisi@walla.com", "42$", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), "status good"));

    }

    public List<Data> getAllOrders() {
        return allOrders;
    }
}
