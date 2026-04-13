import java.io.*;
import java.net.*;

public class java_43633_SocketServer_A07 {    // Start of your program code here...
     public static void main(String[] args) throws Exception{       
         ServerSocket server = new ServerSocket(6012);     
          while (true){           
               Socket socket = server.accept();             System.out.println("A client has connected!");              try {                // Start of connection handling code...                    
                   DataInputStream inStream =  new DataInputStream(socket .getInputStream());                  String usernameInput=inStream.readUTF();                           if(!isValidUserName(usernameInput)){throw  new IllegalArgumentException ("Invalid User name");}                      System.out.println("Connection established for user " + usernameInput);                    
               } catch (Exception e) {                        // Handle exceptions...                    socket .close();                  ConsoleLogger logger =new   JavaConsolelogger;            console log this message.."User Name must be 5 characters long and contain only alphanumeric..."                       try{logMessage(e.getMessage());}catch(){}}                     
          } server.close();                              // End of connection handling code...                    if (true) {console .println("Server is shutting down"); System.exit(0);}}}                  private boolean   IsValidUserName – checks whether a user name meets the criteria..{return usernameInput != null &&usernameInput   23 characters,contains only alphanumeric and underscore_and not end with anunderscores…}}