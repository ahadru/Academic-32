import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {
	
	private Socket socket;
	
	public FileClient(String host, int port, String file) {
		try {
			socket = new Socket(host, port);
			sendFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void sendFile(String file) throws IOException {
		DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		
		while (fileInputStream.read(buffer) > 0) {
			dataOutputStream.write(buffer);
		}
		
		fileInputStream.close();
		dataOutputStream.close();	
	}
	void sendName(String fileName){
		
	}
	
	public static void main(String[] args) {
		FileClient fc = new FileClient("localhost", 1451, "cat.jpeg");
	}

}