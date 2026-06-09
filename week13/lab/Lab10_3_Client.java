package week13.lab;

import java.io.*;
import java.net.*;

public class Lab10_3_Client {
    public static void main(String[] args) {
        Socket myClient = null;
        BufferedReader is = null;
        DataOutputStream os = null;

        try {
            myClient = new Socket("127.0.0.1", 5000);

            is = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
            os = new DataOutputStream(myClient.getOutputStream());

            os.writeBytes("Hello.\n");

            String reply = is.readLine(); 
            System.out.println("TCP Client: " + reply);

            os.close();
            is.close();
            myClient.close();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}