import java.io.IOException;

public class FileServer{
	public static void main(String[] args) {
		FileReceivingServer frs = new FileReceivingServer(5500);
		try {
			String fileNameAndSize = frs.saveNameAndSize();
			if(fileNameAndSize == null){
				frs.sendResponse("400");
			}
			else{
				frs.sendResponse("200");
				String []str = fileNameAndSize.split(" ");
				frs.saveFile(str[0], Integer.parseInt(str[1]));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}