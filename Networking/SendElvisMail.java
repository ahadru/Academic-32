import java.net.*;
import java.io.*;

public class SendElvisMail {
 public static void main(String s[]) {
   //
   //  Send fake mail from Elvis Presley
   //
   //  SendElvisMail [mail server] [recipient address]
   //               mail server can be hostname or IP address
   //
   //   ex.  SendElvisMail mail.company.com myFriend@somewhere.qc.ca
   //
   SendElvisMail t = new SendElvisMail();
   //t.sendMail(s[0], s[1]);
   t.sendMail("127.0.0.1", "info@ahad.com");
 }

 public void sendMail(String mailServer, String recipient) {
   try {
      Socket s = new Socket(mailServer, 25);
      BufferedReader in = new BufferedReader
          (new InputStreamReader(s.getInputStream(), "8859_1"));
      BufferedWriter out = new BufferedWriter
          (new OutputStreamWriter(s.getOutputStream(), "8859_1"));

      send(in, out, "HELO theWorld");
      // warning : some mail server validate the sender address
      //           in the MAIL FROm command, put your real address here
      send(in, out, "MAIL FROM: <ahadmail@ahad.com>");
      send(in, out, "RCPT TO: " + recipient);
      send(in, out, "DATA");
      send(out, "Subject: In the ghetto");
      send(out, "From: Ahad Mail <ahadmail@ahad.com>");
      send (out, "\n");
      // message body
      send(out, "I'm alive. Help me!");
      send(out, "\n.\n");
      send(in, out, "QUIT");
      s.close();
   }
   catch (Exception e) {
      e.printStackTrace();
   }
 }

 public void send(BufferedReader in, BufferedWriter out, String s) {
   try {
      out.write(s + "\n");
      out.flush();
      System.out.println(s);
      s = in.readLine();
      System.out.println(s);
   }
   catch (Exception e) {
      e.printStackTrace();
   }
 }

 public void send(BufferedWriter out, String s) {
   try {
      out.write(s + "\n");
      out.flush();
      System.out.println(s);
   }
   catch (Exception e) {
      e.printStackTrace();
   }
 }
}