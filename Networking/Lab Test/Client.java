import java.net.*;
import java.io.*;

public class Client {
    public static void main(final String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 1999)) {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello World");
            dos.close();
        }
    }
}
