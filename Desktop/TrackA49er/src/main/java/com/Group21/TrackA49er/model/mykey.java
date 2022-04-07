/**
 * Represents the composite key of database
 * @author Group 21 4155
 *@version 1.0
 * @date 3/17/2022
 */

package com.Group21.TrackA49er.model;

import java.io.Serializable;

public class mykey implements Serializable {
    //Represents columns a part of composite key.
    private int tim;
    private String device;
    private String dow;

    public mykey(int tim, String device,String dow) {
        this.tim = tim;
        this.device = device;
        this.dow = dow;
    }

    public mykey() {
    }
}
