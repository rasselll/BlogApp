package com.myproj.blogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * Created by user on 8/9/2017.
 */



public class timetable  extends AppCompatActivity {

    private TextView text = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        Calendar cal = Calendar.getInstance();

        int thisMonth = cal.get(Calendar.MONTH);

        InputStream is = null;


        if(thisMonth == Calendar.JANUARY){
            is = getResources().openRawResource(R.raw.salah_jan);

        }else if(thisMonth == Calendar.FEBRUARY) {
            is = getResources().openRawResource(R.raw.salah_feb);

        }else if(thisMonth == Calendar.MARCH) {
            is = getResources().openRawResource(R.raw.salah_mrch);

        }else if(thisMonth == Calendar.APRIL) {
            is = getResources().openRawResource(R.raw.salah_apr);

        }else if(thisMonth == Calendar.MAY) {
            is = getResources().openRawResource(R.raw.salah_may);

        }else if(thisMonth == Calendar.JUNE) {
            is = getResources().openRawResource(R.raw.salah_jun);

        }else if(thisMonth == Calendar.JULY) {
            is = getResources().openRawResource(R.raw.salah_jul);

        }else if(thisMonth == Calendar.AUGUST) {
            is = getResources().openRawResource(R.raw.salah_aug);

        }else if(thisMonth == Calendar.SEPTEMBER) {
            is = getResources().openRawResource(R.raw.salah_sep);

        }else if(thisMonth == Calendar.OCTOBER) {
            is = getResources().openRawResource(R.raw.salah_oct);

        }else if(thisMonth == Calendar.NOVEMBER) {
            is = getResources().openRawResource(R.raw.salah_nov);

        }else if(thisMonth == Calendar.DECEMBER) {
            is = getResources().openRawResource(R.raw.salah_dec);

        }


        Writer writer = new StringWriter();
        char[] buffer = new char[1024];


        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();

        //fajr string
        String fjrBegin = "";
        String fjrJamat = "";

        //zuhur string
        String zhrBegin = "";
        String zhrJamat = "";

        //asr string
        String aBegin = "";
        String aJamat = "";

        //magrib string
        String mgrbBegin = "";
        String mgrbJamat = "";

        //eisha string
        String eshaBegin = "";
        String eshaJamat = "";



        //fajr
        TextView fajrBegin = (TextView) findViewById(R.id.fajr_begins);
        TextView fajrJamat = (TextView) findViewById(R.id.fajr_jamat);

        //zuhur
        TextView zuhurBegin = (TextView) findViewById(R.id.zuhur_begin);
        TextView zuhurJamat = (TextView) findViewById(R.id.zuhur_jamat);

        //asr
        TextView asrBegin = (TextView) findViewById(R.id.asr_begin);
        TextView asrJamat = (TextView) findViewById(R.id.asr_jamat);

        //magrib
        TextView magribBegin = (TextView) findViewById(R.id.magrib_begin);
        TextView magribJamat = (TextView) findViewById(R.id.magrib_jamat);

        //eisha
        TextView eishaBegin = (TextView) findViewById(R.id.eisha_begin);
        TextView eishaJamat = (TextView) findViewById(R.id.eisha_jamat);

        //err.setText(jsonString);

        try {
            JSONObject array = new JSONObject(jsonString);
            JSONArray jNode = null;

            if(thisMonth == Calendar.AUGUST) {
                 jNode = array.optJSONArray("salah_august");

            }else if(thisMonth == Calendar.JANUARY){

            }


            if(thisMonth == Calendar.JANUARY){
                jNode = array.optJSONArray("salah_january");

            }else if(thisMonth == Calendar.FEBRUARY) {
                jNode = array.optJSONArray("salah_febuary");

            }else if(thisMonth == Calendar.MARCH) {
                jNode = array.optJSONArray("salah_march");

            }else if(thisMonth == Calendar.APRIL) {
                jNode = array.optJSONArray("salah_april");

            }else if(thisMonth == Calendar.MAY) {
                jNode = array.optJSONArray("salah_may");

            }else if(thisMonth == Calendar.JUNE) {
                jNode = array.optJSONArray("salah_june");

            }else if(thisMonth == Calendar.JULY) {
                jNode = array.optJSONArray("salah_july");

            }else if(thisMonth == Calendar.AUGUST) {
                is = getResources().openRawResource(R.raw.salah_aug);

            }else if(thisMonth == Calendar.SEPTEMBER) {
                jNode = array.optJSONArray("salah_september");

            }else if(thisMonth == Calendar.OCTOBER) {
                jNode = array.optJSONArray("salah_october");

            }else if(thisMonth == Calendar.NOVEMBER) {
                jNode = array.optJSONArray("salah_november");

            }else if(thisMonth == Calendar.DECEMBER) {
                jNode = array.optJSONArray("salah_december");

            }




            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
            int today = dayOfMonth-1;
            for(int i = today; i < dayOfMonth; i++){


                JSONObject childObject = jNode.getJSONObject(today);

                //fajr
                fjrBegin += childObject.optString("fajrstart");
                fjrJamat += childObject.optString("fajrjamat");

                //zuhur
                zhrBegin += childObject.optString("zuhurstart");
                zhrJamat += childObject.optString("zuhurjamat");

                //asr
                aBegin += childObject.optString("asrstart");
                aJamat += childObject.optString("asrjamat");

                //magrib
                mgrbBegin += childObject.optString("magribstart");
                mgrbJamat += childObject.optString("magribstart");

                //eisha
                eshaBegin += childObject.optString("ishastart");
                eshaJamat += childObject.optString("ishaend");
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }


        //fajr
        fajrBegin.setText(fjrBegin);
        fajrJamat.setText(fjrJamat);

        //zuhur
        zuhurBegin.setText(zhrBegin);
        zuhurJamat.setText(zhrJamat);

        //asr
        asrBegin.setText(aBegin);
        asrJamat.setText(aJamat);

        //magrib
        magribBegin.setText(mgrbBegin);
        magribJamat.setText(mgrbJamat);

        //eisha
        eishaBegin.setText(eshaBegin);
        eishaJamat.setText(eshaJamat);

   /*         String currentTimeStr = "19:04 PM";

            Date userDate = new Date();
            String userDateWithoutTime = new SimpleDateFormat("yyyyMMdd").format(userDate);

            String currentDateStr = userDateWithoutTime + " " + currentTimeStr;
        Date currentDate = null;
        try {
            currentDate = new SimpleDateFormat("yyyyMMdd h:mm a").parse(currentDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
         TextView test = (TextView) findViewById(R.id.testtext);
      //  eishaJamat.setText(eshaJamat);

        if (userDate.compareTo(currentDate) >= 0) {
                System.out.println(userDate + "\n is greater than or equal to \n" + currentDate);

            test.setText(userDate + "\n is greater than or equal to \n" + currentDate);
            } else {
                System.out.println(userDate + " is less than " + currentDate);
            test.setText(userDate + "\n is less than \n" + currentDate);

        }*/



      //  TextView test = (TextView) findViewById(R.id.testtext);
       // eishaJamat.setText(eshaJamat);




    }


}




