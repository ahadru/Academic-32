import java.io.*;
import java.net.*;

public class FileServer{
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        String fileName = dis.readUTF();
        System.out.println("Requested fileName: " + fileName);
        File file = new File(fileName);
        if(file.exists()){
            dout.writeUTF("OK");
            dout.flush();
            long fileSize = (long) file.length();
            dout.writeUTF(Long.toString(fileSize));
            dout.close();
            FileInputStream fileReader = new FileInputStream(file);
            byte[] buffer = new byte[1024];

            while(fileReader.read(buffer) > 0){
                dout.write(buffer);
            }
            dout.flush();
            fileReader.close();
        }
        else{
            dout.writeUTF("File Not Found");
        }
        dis.close();
        dout.close();
        socket.close();
        server.close();
    }
}