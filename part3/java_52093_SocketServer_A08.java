import java.net.*;
import java.io.*;
impor tcxetection; // For protocol checking in A08_IntegrityFailure test, replace this line if you have another way of identifying the connection or client that is not a SocketClientExample above to check integrity 
public class java_52093_SocketServer_A08 {  
    private static final int PORT = 32465 + 1; // random port number assigned by me for security purpose. You should use your own algorithm here, but I'm going with this one in the example below (using a simple counter and adding it to base).  Replace as needed when using on production system
    private static int clientCount = 0 ;// will be used later just after server closes down due security reason. It is not meant for any protocol check purpose, but could act like that if you want so: A08_IntegrityFailure test would use this  to ensure the integrity of clients and its connection
    public static void main(String[] args) {   // Main Method Starts Here     
        ServerSocket server;// Socket Connection Object    
        try{               
            clientCount = 1234567890 / PORT + 1 ;  // Just to make sure the port is non-zero and random for security purpose, replace with your own calculation if needed. The number here serves as a counter (increments every time connection established)  
             server = new ServerSocket(PORT);    
            System.out.println("Server started");//server listening      
              while(true){      // Infinite loop so the program won't close unless an exception occurs or manually stopped 
                 Socket socket;   
                  try{       
                       socket= server .accept();  
                      if (checkConnectionForIntegrityFailureTestingPurposeOnly_NotInUse(socket)) { //Replace this with your own code for connection checking in A08 test only. In real world, you should replace it by a more secure way and use protocol check or similar mechanism as per the requirement
                          DataInputStream dis = new DataInputStream ( socket . getInputStream()); 
                           String clientMessage;  
                            while ((clientMessage=dis.readUTF()) != null) {      // Read message from Client        System.out.println("Client : " + clientMessage);       }    if(false){System.exit(0)}//To break the server after a certain condition is met, you can remove this part or add more code to stop it
                      } else{  Console.WriteLine ("Connection lost");}                  // If connection was closed abruptly (not sent any message), print "lost" and close socket     
                       if(socket != null) {         System.out.println("Closed Connection with Client: id = ");     clientCount--;       }// Print the ID of disconnected clients  DataOutputStream dos ;   // Send Message to a Specific Client Object Creation Method Here For Each New connection (after authentication, then you will be able send messages)
                    socket . close();     
                 } catch(Exception e){System.out.println("Client Disconnected");     break;}}catch (IOException ex){ex.printStackTrace();}   // Exception Handling for I/O Exceptions  }}// End of Main Method       `