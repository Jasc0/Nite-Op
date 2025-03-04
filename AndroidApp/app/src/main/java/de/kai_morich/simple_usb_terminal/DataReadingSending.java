package de.kai_morich.simple_usb_terminal;

import android.widget.TextView;

import java.util.ArrayList;
import com.mongodb.*;

public class DataReadingSending {
    private ArrayList<byte[]> receivedBytes;
    TextView debug_text;
    MongoClient mongoClient;

    DataReadingSending(TextView debug){
        receivedBytes = new ArrayList<>();
        debug_text = debug;
        mongoClient = new MongoClient();
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
