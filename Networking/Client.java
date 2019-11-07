import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("I am client");
            out.flush();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}