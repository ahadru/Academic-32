import java.net.*;
import java.io.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("127.0.0.1", 1999)) {
            // Create a data input stream from the socket
            DataInputStream is = new DataInputStream(s.getInputStream());

            // Read the file name
            String fileName = is.readUTF();
            System.out.println("File name: " + fileName);

            // Read the file size
            int fileSize = is.readInt();
            System.out.println("File size: " + fileSize);

            // Create a byte array of size of the file
            byte[] mybytearray = new byte[fileSize];

            // Create a file output stream to write a new file
            FileOutputStream fos = new FileOutputStream("new-"+fileName);

            // Create a buffered output stream from the file o/p stream
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // read from the input stream into to the byte array and get the length
            int bytesRead = is.read(mybytearray, 0, mybytearray.length);
            // write to the file reading from the byte array
            bos.write(mybytearray, 0, bytesRead);
            bos.close();
        }
    }
}