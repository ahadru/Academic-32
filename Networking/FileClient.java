import java.io.*;
import java.net.*;
import java.util.*;  


public class FileClient{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);  
        Socket socket = new Socket("localhost", 6666);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        System.out.print("Enter File Name: ");
        String fileName = in.next();
        dout.writeUTF(fileName);
        String res = dis.readUTF();
        if(res.equals("OK")){
            String fileSize = dis.readUTF();
            int remaining = Integer.parseInt(fileSize);
            System.out.println("FileSize: " + fileSize);
            File file = new File("server-"+fileName);
            FileOutputStream fileIn = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int totalRead = 0;
            int read = 0;
            while((read = dis.read(buffer,0, Math.min(buffer.length,remaining)))>0){
                fileIn.write(buffer,0,read);
                remaining -= buffer.length;
                totalRead += buffer.length;
                System.out.println(totalRead + " read...");
            }
            fileIn.close();
        }
        else{
            System.out.println(res);
        }
        dout.close();
        dis.close();
        socket.close();
        in.close();
    }
}