package de.kai_morich.simple_usb_terminal;

import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import com.mongodb.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DataReadingSending {
    private String receivedBytesToString;
    TextView debug_text;
    MongoClient mongoClient;
    private static DataReadingSending instance;

    public DataReadingSending(TextView tv){
        debug_text = tv;
        try {
//            File myObj = new File("z_secrets.txt");
//            Scanner scnr = new Scanner(myObj);
//            String serverString = scnr.nextLine();
//            scnr.close();
            mongoClient = new MongoClient("mongodb+srv://niteop:F8R48JwKswzS8nf8@testercluster.xcsho.mongodb.net/");
        } catch (Exception e) {
            debug_text.setText("No DB string OR no data flow");
        }
    }

    public void receiveData(byte[] data){
        receivedBytesToString = new String(data);
    }

    public void sendDataToDatabase(String dataToParse){
        debug_text.setText(dataToParse);
    }

    public int[] parseData(String dataAsString){
        String[] parsed = dataAsString.split(" ");
        int[] vals = new int[parsed.length];
        try{
            for(int i = 0; i < parsed.length; ++i){
                vals[i] = Integer.getInteger(parsed[i]);
            }
        }catch(Exception e){
            debug_text.setText("parse data error");
        }

        return vals;
    }

    public String getData(){
        return receivedBytesToString;
    }

    public static synchronized DataReadingSending getInstance() {
        if (instance == null) {
            instance = new DataReadingSending(null); // Create a new instance if it doesn't exist
        }
        return instance;
    }

    public void initialize(TextView textView) {
        if (this.debug_text == null) { // Ensure the TextView is only set once
            debug_text = textView;
            try {
//            File myObj = new File("z_secrets.txt");
//            Scanner scnr = new Scanner(myObj);
//            String serverString = scnr.nextLine();
//            scnr.close();
                mongoClient = new MongoClient("mongodb+srv://niteop:F8R48JwKswzS8nf8@testercluster.xcsho.mongodb.net/");
            } catch (Exception e) {
                debug_text.setText("No DB string OR no data flow");
            }
        }
    }


}
