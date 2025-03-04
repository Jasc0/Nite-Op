package de.kai_morich.simple_usb_terminal;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;
import com.mongodb.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class DataReadingSending {
    private ArrayList<byte[]> receivedBytes;
    TextView debug_text;
    MongoClient mongoClient;

    DataReadingSending(TextView debug){
        receivedBytes = new ArrayList<>();
        debug_text = debug;
        try {
            File myObj = new File("z_secrets.txt");
            Scanner myReader = new Scanner(myObj);
            String serverString = myReader.nextLine();
            myReader.close();
            mongoClient = new MongoClient(serverString);
        } catch (FileNotFoundException e) {
            debug_text.setText("No DB string");
        }
    }

    public void receiveData(byte[] data){
        receivedBytes.add(data);
        String s = "hi: ";
        for (byte b : data) {
            s += b + " ";
        }
        debug_text.setText(s);
    }

    public void sendData(){

    }

}
