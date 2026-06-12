package week14.lab;

import java.io.*;
import java.net.*;

public class Lab11_1_client { 
    public final static int MY_PORT = 5000; 
    public final static int TO_PORT = 5001;
    public static void main(String argv[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(MY_PORT);
        byte[] buf = new byte[256];
        System.out.print("Please input a keyword: ");
        int n = System.in.read(buf);
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buf, n, addr, TO_PORT);
        ds.send(packet);
        
        DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
        ds.receive(packet2);
        buf = packet2.getData();
        for (int i = 0; i < packet2.getLength(); i++) {
            System.out.print((char)buf[i]);
        }
        System.out.println();
        ds.close();
    }
}
