import java.io.*;
import java.net.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Server{
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3333);
            System.out.println("Server is Ready.");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            boolean stop = false;
            while(!stop){
                Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientString = in.readLine();
                System.out.println(socket.getInetAddress() + ": " + clientString);
                if(clientString.equals("Hello")){
                    out.println("Welcome");
                }
                else if(clientString.equals("Time")){
                    out.println(tf.format(LocalTime.now()));
                }
                else if(clientString.equals("Date")){
                    out.println(df.format(LocalDate.now()));
                }
                else if(clientString.equals("DateTime")){
                    out.println(dtf.format(LocalDateTime.now()));
                }
                else{
                    out.println("BAD_CMMAND");
                }
            }
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}