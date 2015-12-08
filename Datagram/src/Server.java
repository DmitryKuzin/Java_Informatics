import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kuzin on 09.11.2015.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(2016);
            Socket s=ss.accept();
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String string=in.readLine();
            System.out.println(string+" <- message from client");
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
            pw.println(string+"<- message from server");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
