import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server ready");
        try {
            ServerSocket socket = new ServerSocket(6666);
            Socket s = socket.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("Client Message= " + str);
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}