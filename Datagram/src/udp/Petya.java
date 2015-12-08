package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by kuzin on 09.11.2015.
 */
public class Petya {
    public static void main(String[] args) {
        try {

                DatagramSocket socket = new DatagramSocket(1011);

            Scanner sc=new Scanner(System.in);
            while(true) {
                DatagramPacket packet = new DatagramPacket(new byte[100], 100);
                socket.receive(packet);
                String str = new String(packet.getData());
                System.out.println(str);
                System.out.println("->");
                str = sc.next();
                DatagramPacket packet1 = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("10.17.15.132"), 2008);
                socket.send(packet1);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
