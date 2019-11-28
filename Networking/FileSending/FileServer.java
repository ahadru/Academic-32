import java.io.IOException;
public class FileServer{
	public static void main(String[] args) {
		FileReceivingServer frs = new FileReceivingServer(5500);
		try {
			System.out.println("Receiving File name...");
			String fileName = frs.saveNameAndSize();
			System.out.println("Name received finished");
			System.out.println("Receiving File...");
			frs.saveFile(fileName,11469);
			System.out.println("File received finished");
			// if(fileName == null){
			// 	frs.sendResponse("400");
			// }
			// else{
			// 	frs.sendResponse("200");
			// 	frs.saveFile(fileName,11469);
			// }		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}