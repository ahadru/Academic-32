import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {
	
	private Socket socket;
	
	public FileClient(String host, int port, String file) {
		try {
			socket = new Socket(host, port);
			//Send File Name Size
			System.out.println("Seding Name....");
			sendName("Cat.jpeg");
			System.out.println("Name send finished.");
			// if(getResponse().equals("200")){
			// 	System.out.println("Server got name.");
			// }
			// else{
			// 	System.out.println("Error happend in sending name");
			// }
			System.out.println("Sending File....");
			sendFile(file);
			System.out.println("File send finished.");
			closeSocket();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void sendFile(String file) throws IOException {
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		
		while (fileInputStream.read(buffer) > 0) {
			dataOutputStream.write(buffer);
		}
		
		fileInputStream.close();
		dataOutputStream.close();	
	}
	void sendName(String fileName) throws IOException{
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(fileName);
		dos.flush();
		dos.close();
	}
	private String getResponse() throws IOException{
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		String response = dataInputStream.readUTF();
		return response;
	}
	private void closeSocket()throws IOException{
		socket.close();
	}
	public static void main(String[] args) {
		FileClient fc = new FileClient("localhost", 5500, "cat.jpeg");
	}
}