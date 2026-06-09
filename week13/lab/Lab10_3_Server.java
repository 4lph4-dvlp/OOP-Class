package week13.lab;

import java.io.*;
import java.net.*;

public class Lab10_3_Server {
    public static void main(String[] args) {
        ServerSocket myService = null;
        Socket serviceClient = null;
        BufferedReader is = null;
        DataOutputStream os = null;

        try {
            myService = new ServerSocket(5000);
            
            serviceClient = myService.accept();

            is = new BufferedReader(new InputStreamReader(serviceClient.getInputStream()));
            os = new DataOutputStream(serviceClient.getOutputStream());

            String message = is.readLine();
            System.out.println("TCP Server:" + message);

            os.writeBytes("Hello2  from TCP Server\n");

            os.close();
            is.close();
            serviceClient.close();
            myService.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}