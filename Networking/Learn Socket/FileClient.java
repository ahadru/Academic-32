import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class FileClient{
    static Scanner cliin = new Scanner(System.in);
    public void sendFile(Socket socket){     
        try{
            System.out.println("Give File Name: ");
            String fileName = cliin.next();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            FileInputStream fis = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) > 0) {
                dos.write(buffer);
            }           
            fis.close();
            dos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",5555);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while(true){
                out.write("FILE_TRANSFER");
                System.out.println(in.readUTF() + ": ");
                String fileName = cliin.next();
                out.write(fileName);
                System.out.println(in.readUTF() + ": ");
                int fileSize = cliin.nextInt();
                out.write(String.valueOf(fileSize));
                System.out.println(in.readUTF());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
            
    }
}