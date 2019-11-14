import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
	
	private ServerSocket serverSocket;
	
	public FileServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = serverSocket.accept();
				saveFile(clientSock);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dataInputStream = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fileOutputStream = new FileOutputStream("testfile.jpeg");
		byte[] buffer = new byte[4096];
		
		int filesize = 15123; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dataInputStream.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			System.out.println("read " + totalRead + " bytes.");
			fileOutputStream.write(buffer, 0, read);
		}
		
		fileOutputStream.close();
		dataInputStream.close();
	}
	
	public static void main(String[] args) {
		FileServer fileServer = new FileServer(1988);
		fileServer.start();
	}

}