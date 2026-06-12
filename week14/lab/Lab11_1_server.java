package week14.lab;

import java.io.*;
import java.net.*;

public class Lab11_1_server { 
    public final static int MY_PORT = 5001;
    public static void main(String argv[]) throws Exception {
        DatagramSocket ds = null;
        byte buf[] = new byte[256];
        ds = new DatagramSocket(MY_PORT);
        DatagramPacket packet = new DatagramPacket(buf, buf.length); 
        ds.receive(packet);
        System.out.println("Got from client: ");
        for (int i = 0; i < packet.getLength(); i++) {
            System.out.print((char)buf[i]); 
        }
        System.out.println();
        ds.send(packet);
        ds.close();
    }
}
