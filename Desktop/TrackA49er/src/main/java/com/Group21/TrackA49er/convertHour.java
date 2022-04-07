/**
 * Converts military hour to regular time as well as AM/PM.
 * @author Group 21 4155
 * @version 1.0
 * @date 3/17/2022
 */


package com.Group21.TrackA49er;

public class convertHour {

    public String convert(int a){
        String b = "";
        switch (a) {
            case 0:
                b = "12 AM";
                break;
            case 1:
                b = "1 AM";
                break;
            case 2:
                b = "2 AM";
                break;
            case 3:
                b = "3 AM";
                break;
            case 4:
                b = "4 AM";
                break;
            case 5:
                b = "5 AM";
                break;
            case 6:
                b = "6 AM";
                break;
            case 7:
                b = "7 AM";
                break;
            case 8:
                b = "8 AM";
                break;
            case 9:
                b = "9 AM";
                break;
            case 10:
                b = "10 AM";
                break;
            case 11:
                b = "11 AM";
                break;
            case 12:
                b = "12 PM";
                break;
            case 13:
                b = "1 PM";
                break;
            case 14:
                b = "2 PM";
                break;
            case 15:
                b = "3 PM";
                break;
            case 16:
                b = "4 PM";
                break;
            case 17:
                b = "5 PM";
                break;
            case 18:
                b = "6 PM";
                break;
            case 19:
                b = "7 PM";
                break;
            case 20:
                b = "8 PM";
                break;
            case 21:
                b = "9 PM";
                break;
            case 22:
                b = "10 PM";
                break;
            case 23:
                b = "11 PM";
                break;
            default:
                a = 500;
                break;
        }
        return b;
    }



}
