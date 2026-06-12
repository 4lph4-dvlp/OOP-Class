package week14.lab;

import java.io.*;
import java.net.*;

public class Lab11_2_client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8189);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true /* autoFlush */);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            // Read and print greeting from the server
            String greeting = in.readLine();
            System.out.println(greeting);
            
            boolean done = false;
            while (!done) {
                String userInput = stdIn.readLine();
                if (userInput == null) {
                    break;
                }
                out.println(userInput);
                
                String response = in.readLine();
                if (response != null) {
                    System.out.println(response);
                }
                
                if (userInput.trim().equals("BYE")) {
                    done = true;
                }
            }
            System.out.println("The End");
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
