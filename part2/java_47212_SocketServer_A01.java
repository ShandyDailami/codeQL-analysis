import java.io.*; // Import necessary Java classes such FileInputStream, InputStreamReader etc..  
import java.net.*; // To use Socket class java_47212_SocketServer_A01 your code for creating TCP/IP socket connections between a client and server application   

public class BrokenAccessServer {    
       public static void main(String args[]) throws Exception 
        {         
            ServerSocket welcomeSocket = new ServerSocket(2018); // creates the listen port  
             while (true){               
                 Socket connectionSocket = welcomeSocket.accept();   
                  System.out.println("Just connected to " +connectionSocket );              
                   PrintWriter out =new PrintWriter  (connectionSocket .getOutputStream(), true);             
                    BufferedReader in  = new BufferedReader(  
                                    new InputStreamReader(connectionSocket.getInputStream()));                
                           String inputLine;                 
                            while ((inputLine=in.readLine()) != null) {                         
                                 System.out.println("Received client: " + inputLine);                     
                                  out.println("Hello Client, your message has been received!");     }              
             }}      //closing Socket  connection  
}