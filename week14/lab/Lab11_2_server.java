package week14.lab;

import java.io.*;
import java.net.*;

public class Lab11_2_server {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */);
            out.println("Hello! Enter BYE to exit.");
            
            boolean done = false;
            while (!done) {
                String line = in.readLine();
                if (line == null) {
                    done = true;
                } else {
                    System.out.println("Server:" + line);
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE")) {
                        done = true;
                    }
                }
            }
            incoming.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
