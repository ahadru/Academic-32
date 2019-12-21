import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class GreetServer{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port){
        String greeting = "F";
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            greeting = in.readLine();
            System.out.println(greeting);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if("hello server".equals(greeting)){
            System.out.println("Server get a request");
            out.println("Hi, Client");
        }
        else{
            out.println("unrecognised greeting");
        }
    }

    public void startEchoServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
         
        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                if (".".equals(inputLine)) {
                    out.println("good bye");
                    break;
                }
                out.println(inputLine);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        GreetServer server = new GreetServer();
        server.start(5555);
    }
}