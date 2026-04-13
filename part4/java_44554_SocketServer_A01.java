import java.io.*;
import java.net.*;

public class java_44554_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{  //line A1_BrokenAccessControl - Broken Access Control Violation is checked here as it's a simple example for Security-sensitive operations in Java Socket programming. It won’t be used directly, but will serve only to demonstrate the concept of secure server handling
        ServerSocket welcomeSocket = new ServerSocket(8765);  //line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate.   
        
       while (true) {  
           Socket connectionSocket  = welcomeSocket.accept();    
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());  //line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate to handle data input stream from client via socket connection  
           System.out.println("A Client is connected");    
            String userInput = inFromClient.readUTF(); //line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate to handle data input stream from client via socket connection  
           if (userInput == null || !( userInput .equals("Authorized User"))){ //line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate to check for suspicious activities 
               DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());    //Again, line violations due to use of standrd Java Libraries only  
             String responseMessage="Access Denied";     //line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate. 
               outToClient .writeUTF(responseMessage);    } else {System.out.println("Authorized User");}   //All is OK with the user input, no further action needed (line A1_BrokenAccessControl - Again violation here because we are using standard libraries and not relying on external frameworks such as Spring or Hibernate). 
        }    
    }     
}//end of main method line   //Again it's a simple example for Security-sensitive operations in Java Socket programming. It won’t be used directly, but will serve only to demonstrate the concept of secure server handling and prevent Broken Access Control Violation