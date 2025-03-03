package de.kai_morich.simple_usb_terminal;

import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DataReadingSending {
    private ArrayList<byte[]> receivedBytes;
    TextView debug_text;

    DataReadingSending(TextView debug){
        receivedBytes = new ArrayList<>();
        debug_text = debug;
    }

    public void recieveData(byte[] data){
        receivedBytes.add(data);
        String s = "hi: ";
        for (byte b : data) {
            s += b + " "; // Print each byte as a number
        }
        debug_text.setText(s);

    }
}
