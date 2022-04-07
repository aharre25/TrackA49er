/**
 * Controller for "UNCC" model. Encapsulates application logic.
 * @author Group 21 4155
 * @version 1.0
 * @date 3/17/2022
 */


package com.Group21.TrackA49er.controller;


import com.Group21.TrackA49er.Service.convertActivity;
import com.Group21.TrackA49er.convertHour;
import com.Group21.TrackA49er.model.uncc;
import com.Group21.TrackA49er.repository.unccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import java.time.LocalDate;
import java.util.*;


@RestController
public class unccController {

    @Autowired
    private unccRepository repo;

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("g.html");
        return modelAndView;
    }

    @RequestMapping("/advertise")
    public ModelAndView advertise() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top3.html");
        return modelAndView;
    }
    @RequestMapping("/advertise2")
    public ModelAndView advertise2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("advertise2.html");
        return modelAndView;
    }

    @RequestMapping("/study")
    public ModelAndView getBottomForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bottom3.html");
        return modelAndView;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/active1", method = RequestMethod.GET)
    public String getTop3(@RequestParam("fhour") String a, @RequestParam("fdow") String b)
    {


        int a1 = Integer.parseInt(a);

        uncc td1;
        uncc td2;
        uncc td3;

        int atkinsCount;
        int unionCount;
        int woodCount;
        String build1;
        String build2;
        String build3;
        convertHour con = new convertHour();
        convertActivity con1 = new convertActivity();



        try{
            td1 = repo.findTop3(a1,b).get(0);
            build1 = td1.getDevice();
            atkinsCount = td1.getCount();
        }catch(IndexOutOfBoundsException e){
            td1 = null;
            atkinsCount = 0;
            build1 = "ERROR";
        }

        try{
            td2 = repo.findTop3(a1,b).get(1);
            build2 = td2.getDevice();
            unionCount = td2.getCount();
        }catch(IndexOutOfBoundsException e){
            td2 = null;
            unionCount =0;
            build2 = "ERROR";

        }
        try{
            td3 = repo.findTop3(a1,b).get(2);
            build3 = td3.getDevice();
            woodCount = td3.getCount();
        }catch(IndexOutOfBoundsException e){
            td3 = null;
            woodCount = 0;
            build3 = "ERROR";

        }
        List<uncc> list = new ArrayList<uncc>();
        //list.add(td1);
        //list.add(td2);
        // list.add(td3);

        return "<html><body>"
                + "<h1>Welcome! Here is how Campus is Looking!</h1>"
                + "<br><h2>At " + con.convert(a1) + " on " + b + " these are the 3 most active places on campus </h2>"
                + "<br><p>"
                + build1
                + " has Approximately "
                + atkinsCount
                + " 49ers "
                + " which is "
                + con1.convertA(atkinsCount)
                + "<br>  "
                + build2
                +  " has Approximately "
                + unionCount
                + " 49ers "
                + " which is "
                + con1.convertA(unionCount)
                + " <br>"
                + build3
                + " has Approximately  "
                + woodCount
                + " 49ers "
                + " which is "
                + con1.convertA(woodCount)
                + "</body></html>";



    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/active2", method = RequestMethod.GET)
    public String getBottom3(@RequestParam("fhour") String a, @RequestParam("fdow") String b)
    {


        int a1 = Integer.parseInt(a);



        uncc td1;
        uncc td2;
        uncc td3;

        int atkinsCount;
        int unionCount;
        int woodCount;
        String build1;
        String build2;
        String build3;
        convertHour con = new convertHour();

        String g = "";

        try{
            td1 = repo.findBottom3(a1,b).get(0);
            build1 = td1.getDevice();
            atkinsCount = td1.getCount();
        }catch(IndexOutOfBoundsException e){
            build1 = "error";
            atkinsCount = 0;
            td1 = null;
        }

        try{
            td2 = repo.findBottom3(a1,b).get(1);
            build2 = td2.getDevice();
            unionCount = td2.getCount();
        }catch(IndexOutOfBoundsException e){
            build2 = "Error";
            unionCount = 0;
            td2 = null;
        }
        try{
            td3 = repo.findBottom3(a1,b).get(2);
            build3 = td3.getDevice();
            woodCount = td3.getCount();
        }catch(IndexOutOfBoundsException e){
            build3 = "Error";
            woodCount = 0;
            td3 = null;
        }
//        List<uncc> list = new ArrayList<uncc>();
//        list.add(td1);
//        list.add(td2);
//        list.add(td3);
        //  return list;

        for(int i =0;i< repo.findBottom3(a1,b).toArray().length;i++){
            if(repo.findBottom3(a1,b).get(i).getCount()<50){
                g = g + "<br> The Building " + repo.findBottom3(a1,b).get(i).getDevice() + " usually has  " +repo.findByTim(a1).get(i).getCount() + " 49ers " + " on " + repo.findBottom3(a1,b).get(i).getDow() ;

            }
        }
        return "<html><body>"
                + "<h1>Welcome! Here is how Campus is Looking!</h1>"
                + "<br><h2>At " + con.convert(a1) + " on " + b + " these are the best places to study on campus </h2>"
                + g
                + "</body></html>";

    }



    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/active3", method = RequestMethod.GET)
    public String getADInfo(@RequestParam("fhour") String a, @RequestParam("fdow") String b)
    {


        int a1 = Integer.parseInt(a);
        String g = "";
        convertHour con = new convertHour();
        uncc td1;
        uncc td2;
        uncc td3;
        int atkinsCount;
        int unionCount;
        int woodCount;
        String build1;
        String build2;
        String build3;

        try{
            td1 = repo.findByTimAndDevice(a1,b).get(0);
            build1 = td1.getDevice();
            atkinsCount = td1.getCount();
        }catch(IndexOutOfBoundsException e){
            td1 = null;
        }

        try{
            td2 = repo.findByTimAndDevice(a1,b).get(1);
            build2 = td2.getDevice();
            unionCount = td2.getCount();
        }catch(IndexOutOfBoundsException e){
            td2 = null;
        }
        try{
            td3 = repo.findByTimAndDevice(a1,b).get(2);
            build3 = td3.getDevice();
            woodCount = td3.getCount();
        }catch(IndexOutOfBoundsException e){
            td3 = null;
        }
//        List<uncc> list = new ArrayList<uncc>();
//        list.add(td1);
//        list.add(td2);
//        list.add(td3);


        for(int i =0;i< repo.findByTimAndDevice(a1,b).toArray().length;i++){
            g = g + "<br> The Building " + repo.findByTimAndDevice(a1,b).get(i).getDevice() + " usually has this many connections " +repo.findByTimAndDevice(a1,b).get(i).getCount() + " at " + con.convert(a1) + " on " + repo.findByTimAndDevice(a1,b).get(i).getDow() ;
        }

        return "<html><body>" +
                g
                + "</body></html>";

    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/active4", method = RequestMethod.GET)
    public String getADInfoByTime(@RequestParam("fhour") String a)
    {


        int a1 = Integer.parseInt(a);
        Formatter format = new Formatter();
        Calendar gfg_calender = Calendar.getInstance();
        format = new Formatter();
        format.format("%tH",gfg_calender);
        int hour = Integer.parseInt(String.valueOf(format));



        uncc td1;
        uncc td2;
        uncc td3;

        int atkinsCount;
        int unionCount;
        int woodCount;
        String build1;
        String build2;
        String build3;


        try{
            td1 = repo.findByTim(a1).get(0);
            build1 = td1.getDevice();
            atkinsCount = td1.getCount();
        }catch(IndexOutOfBoundsException e){
            td1 = null;
        }
        String day = LocalDate.now().getDayOfWeek().name();
        List<uncc> list = new ArrayList<uncc>();
        String h = "The current busiest location is " +repo.findTop3(hour,day).get(0).getDevice();
        String g = "";
        convertHour con = new convertHour();
        for(int i =0;i< repo.findByTim(a1).toArray().length;i++){
            if(repo.findByTim(a1).get(i).getCount()>100){
                g = g + "<br> The Building " + repo.findByTim(a1).get(i).getDevice() + " usually has this many connections " +repo.findByTim(a1).get(i).getCount() + " at " + con.convert(a1) + " on " + repo.findByTim(a1).get(i).getDow() ;

            }
        }
        return "<html><body>" +
                h + "<br><br><br>" +
                g
                + "</body></html>";

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/active5", method = RequestMethod.GET)
    public Map<String, String> getAll(@RequestParam("fhour") String a, @RequestParam("fdow") String b)
    {
        int a1 = Integer.parseInt(a);
        List<uncc> td1;

        try{
            td1 = repo.findAll(a1,b);

        }catch(IndexOutOfBoundsException e){
            td1 = null;
            System.out.print("s");
        }
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < td1.size(); i++) {
            map.put(td1.get(i).getDevice(),Integer.toString(td1.get(i).getCount()));
        }

        return map;
    }

}








