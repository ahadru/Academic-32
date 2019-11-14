import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class FileReceivingServer{
    private ServerSocket serverSocket;
    private Socket socket;
    private final int PORT;
    public FileReceivingServer(int port){
        PORT = port;
        try{
            serverSocket = new ServerSocket(PORT);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        try {
            socket = serverSocket.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveFile(String filePath,int fileSize) throws IOException {   
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream("filePath");
        byte[] buffer = new byte[16384];
    
        int read = 0;
        int totalRead = 0;
        int remaining = fileSize;
        while((read = dataInputStream.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fileOutputStream.write(buffer, 0, read);
        }
        
        fileOutputStream.close();
        dataInputStream.close();
    } 
    public String saveNameAndSize()throws IOException{
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String fileNameAndSize = dataInputStream.readUTF();
        return fileNameAndSize;
    }
    public void sendResponse(String res) throws IOException{
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(res);		
    }
    public void closeSockets() throws IOException{
        serverSocket.close();
        socket.close();
    }
}