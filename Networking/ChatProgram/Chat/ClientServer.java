import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ClientServer {
    private Socket socket = null;
    public ClientServer(String address, int port){
        try{
            this.socket = new Socket(address, port);
        }
        catch(UnknownHostException h){
            System.out.println(h);
        }
        catch(IOException i){
            System.out.println(i);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    void connect(String message){
        try{
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
            dout.close();
        }
        catch(Exception i){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        //Start Server
        String IPa;
        int port;

        Scanner in = new Scanner(System.in);
        System.out.println("Set a unique IP");
        //IPa = in.nextLine();
        IPa = "localhost";

        System.out.println("Set a unique port");
        port = in.nextInt();
        //port = 5000;

        Server server = new Server(port);
        Thread t1 = new Thread(server);
        t1.start();
        System.out.println("Server is started");

        ClientServer client = new ClientServer(IPa, port);
        System.out.println("Your ready to Chat");

        String m = "";
        while(!m.equals("/quit")){
            m = in.nextLine();
            client.connect(m);
            System.out.println("Me: " + m);
        }
        in.close();
    }
}
class Server extends Thread{
    private int port;
    public Server(int port){
        this.port = port;
    }
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("::-> " + str);
            if(str.equals("/quit")){
                ss.close();
            }
        } catch (Exception e) {
            System.out.println("In Server " + e);
        }
    }
} 