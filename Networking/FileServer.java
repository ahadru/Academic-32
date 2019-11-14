import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
	
	private ServerSocket fileReceivingServerSoc;
	private ServerSocket nameReceivingServerSoc;
	
	public FileServer(int port) {
		try {
			fileReceivingServerSoc = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = fileReceivingServerSoc.accept();
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
		
		fos.close();
		dis.close();
		clientSock.close();
		fileReceivingServerSoc.close();
	}

	void saveFileName(Socket nameReceivingSoc) throws IOException{

	}
	
	public static void main(String[] args) {
		final int FILE_RECEIVING_PORT = 1971;
		final int NAME_RECEIVING_PORT = 1972; 

		new FileServer(FILE_RECEIVING_PORT);
		fs.start();

		nameReceivingServerSoc = new ServerSocket(NAME_RECEIVING_PORT);
		Socket nameRecSoc = nameReceivingServerSoc.accept();

	}

}