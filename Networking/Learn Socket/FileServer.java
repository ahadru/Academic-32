import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class FileServer extends Thread{
    private ServerSocket serverSocket;
    private Socket socket;

    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveFile(PrintWriter out, DataInputStream in){
        try {
            String fileName;
            int fileSize;
            out.println("Send Name.");
            fileName = in.readUTF();
            out.println("Send Size.");
            fileSize = Integer.parseInt(in.readUTF());
            out.println("Now send the file.");
            File file = new File("d-" + fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataInputStream netRecFile = new DataInputStream(socket.getInputStream());
            byte[] buffer = new byte[1024];

            int read = 0;
            int totalRead = 0;
            int remaining = fileSize; 
            
            while((read = netRecFile.read(buffer,0,Math.min(buffer.length,remaining))) > 0){
                totalRead += read;
                remaining -= read;
                System.out.println("read " + totalRead + " bytes..");
                fileOutputStream.write(buffer,0,read);
            }
            if(remaining == 0){
                System.out.println("Congrats, Successfully read the file.");
            }
            netRecFile.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void run(){
        System.out.println("Server is ready to communicate....");
        start(5555);
        System.out.println("Send FILE_TRANSFER msg for file transmiting");
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while(true){
                String request = in.readUTF();
                System.out.println(request);
                if("FILE_TRANSFER".equals(request)){
                    saveFile(out, in);
                }
                else if("QUIT".equals(request)){
                    break;
                }
                else{
                    out.write("Server is Ready..");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new FileServer().start();
    }
}