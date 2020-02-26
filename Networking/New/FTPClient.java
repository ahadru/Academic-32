import java.io.*;
import java.net.*;

class FTPClient{
    public static void main(String[] args) {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);

            String ipAddress = "";
            String fileName = "";

            boolean isValid = false;

            while(!isValid){
                System.out.print("Please enter a valid Server ip address: ");
                ipAddress = reader.readLine();
                isValid = isValidIP(ipAddress);
            }

            System.out.print("Please enter a filename: ");
            fileName = reader.readLine();

            Socket socket = new Socket(ipAddress, 9090);
            BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //send desired filename
            out.println(fileName);
            int code = input.read();
            if(code == 1){
                BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("Downloads/" + fileName));
                byte[] buffer = new byte[1024];
                int byteRead = 0;
                while((byteRead = input.read(buffer)) != -1){
                    System.out.println(byteRead + " byte downloaded..");
                    outputFile.write(buffer, 0, byteRead);
                    outputFile.flush();
                }
                System.out.println();
                System.out.println("File: " + fileName + " was successfully downloaded.");
            }
            else{
                System.out.println("File not found on the server.");
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.toString());
        }
    }
    static boolean isValidIP(String ip){
        return true;
    }
}