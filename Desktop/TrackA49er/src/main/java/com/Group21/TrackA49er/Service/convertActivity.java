package com.Group21.TrackA49er.Service;

public class convertActivity {

    public String convertA(int a){

        String b = "";

      if(a<100){
          return "Not Busy";
      }else if(a<500){
          return "Slightly Busy";
      }else{
          return "Very Busy";
      }


    }



}
