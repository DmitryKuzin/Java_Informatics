import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by kuzin on 09.11.2015.
 */
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress inet=InetAddress.getByName("localhost");
            Socket socket=new Socket(inet,2016);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader ins=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
            pw.println(ins.readLine());
            System.out.println(in.readLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
