/**
 * Represents state of Building(In Terms of connections,time, and day of week)
 * @author Group 21 4155
 * @version 1.0
 * @date 3/17/2022
 */


package com.Group21.TrackA49er.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
@Entity
@IdClass(mykey.class)
public class uncc {

    //Fields are mapped to columns in database. "@Id" indicates column is a part of primary key.
    @Id
    private int tim;
    @Id
    private String device;
    @Id
    private String dow;
    private int count;

    public uncc() {
    }

    public int getTim() {
        return tim;
    }

    public void setTim(int tim) {
        this.tim = tim;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
