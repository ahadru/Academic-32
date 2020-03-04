import java.net.*;
import java.io.*;
import java.util.*;

class Server extends Thread{
    private static ServerSocket serverSocket;
    public static Socket socket;
    public Server(int port){
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String output = (String)dis.readUTF();
            System.out.println("Client: " + output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;

        Server server = new Server(5500);
        server.start();

        while(true){
           try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            input = in.nextLine();
            dos.writeUTF(input);
            if(input.equals("QUIT")){
                //server.stop();   
                socket.close();
                serverSocket.close();
                break;
            }
            dos.flush();  
           } catch (Exception e) {
               //TODO: handle exception
               System.out.println(e);
           }
        }
    }
}