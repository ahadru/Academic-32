import java.net.*;
import java.io.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        String fileName = "f.txt";
        try (ServerSocket ss = new ServerSocket(1999)) {
            File myFile = new File(fileName);
            Socket s = ss.accept();     // Get the client

            // Now create a byte array of length of the file
            byte[] mybytearray = new byte[(int) myFile.length()];

            // Create a buffered input stream from the file and read into the byte array
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
            bis.read(mybytearray, 0, mybytearray.length);

            // Create a data output stream from the client
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // write the file name to the data output stream
            dos.writeUTF(fileName);
            dos.flush();

            // write the file size
            dos.writeInt(mybytearray.length);
            dos.flush();

            // write the byte array
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            bis.close();
        }
    }
}