import java.net.*;
import java.io.*;

class Client extends Thread{
    public Socket socket;
    public Client(int port){
        socket = Socket("localhost",port);
    } 
    public void run(){
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println((String)dis.readUTF());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;

        Client client = new Client(5500);
        client.start();
        while(true){
            DataOutputStream dos = new DataInputStream(socket.getOutputStream());
            input = in.nextLine();
            dos.writeUTF(input);
            dos.flush();
            if(input.equal("QUIT")){
                try {
                    server.stop();
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println(e);
                }
                socket.close();
                serverSocket.close();
                break;
            }
        }

    }
}