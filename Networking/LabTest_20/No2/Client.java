import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class Client{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Socket socket = null;
            boolean success = false;
            boolean stop = false;
            while(!stop){
                socket = new Socket("localhost",3333);
                if(socket.isConnected() && !success){
                    System.out.println("Success");
                    success = true;
                }
                String comm = "";
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                System.out.print("Command: ");
                comm = input.next();
                if(comm.equals("QUIT")){
                    System.out.println("Clossing.....\nGood Bye.");
                    socket.close();
                    break;
                }
                out.println(comm);
                String response = in.readLine();
                System.out.println("Response: " + response);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Connection Failed");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}