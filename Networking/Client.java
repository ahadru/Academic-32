import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Server Address: ");
        String add = in.nextLine();
        try {
            Socket socket = new Socket(add, 6666);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("I am client");
            out.flush();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        in.close();
    }
}