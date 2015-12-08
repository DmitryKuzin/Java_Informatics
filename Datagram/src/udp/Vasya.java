package udp;

import java.io.IOException;
import java.net.*;

/**
 * Created by kuzin on 09.11.2015.
 */
public class Vasya {
    public static void main(String[] args) {
        try {
            DatagramSocket socket=new DatagramSocket(1010);
            String message="Hello_Petya";
            DatagramPacket packet=new DatagramPacket(message.getBytes(),message.getBytes().length, InetAddress.getByName("localhost"),1011);
            socket.send(packet);
            DatagramPacket packet2=new DatagramPacket(new byte[100],100);
            socket.receive(packet2);
            String out=new String(packet2.getData());
            System.out.println(out);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
