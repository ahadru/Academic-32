import java.io.*;
import java.net.*;

class PortScanner{
    public static void main(String[] args) {
        int port = 1;
        int c = 0;
        while(port <= 65535){
            try {
                ServerSocket sc = new ServerSocket(port);
                sc.close();
            } catch (IOException e) {
                //TODO: handle exception
                System.out.println("Port: " + port + " is open");
                c++;
            }
            port++;   
        }
        System.out.println(c + " Number of port is open");
    }
}