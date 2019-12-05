import java.io.*;
import java.net.*;

public class MailClient {
    public static void main(String[] args) throws Exception {
        String server = "localhost";
        int port = 25;
        String from = "ahadmail@ahad.com";
        String to = "info@ahad.com";
        Socket socket = new Socket(server, port);
        PrintWriter os = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("HELO " + InetAddress.getLocalHost().getHostName());
        os.println("HELO " + "ahad.com");
        System.out.println("Response1: " + bReader.readLine());

        System.out.println("MAIL From:<" + from + ">");
        os.println("MAIL From:<" + from + ">");
        System.out.println("Response 2: " + bReader.readLine());

        System.out.println("RCPT TO:<" + to + ">");
        os.println("RCPT TO:<" + to + ">");
        System.out.println("Response 3: " + bReader.readLine());

        System.out.println("Sending Data.....");
        os.println("DATA");
        System.out.println("Response 4: " + bReader.readLine());

        os.println("From:ahadmail@ahad.com");
        os.println("To:info@ahad.com");
        os.println("Subject: First Mail");
        os.println();
        os.println("Hello Friend, This is my first mail.");

        System.out.println(".");
        os.println(".");
        System.out.println("Response 5: " + bReader.readLine());

        os.println("QUIT");
        System.out.println("Response 6: " + bReader.readLine());

        System.out.println("Response 7: " + bReader.readLine());
        socket.close();
    }
}
