import java.io.*;  // Import necessary classes for IO operations and objects  
import java.net.*;    // For ServerSocket Class & Socket Connections    
public class java_43699_SocketServer_A01 {      
        private static final int port = 12345;      // Set up the Port Number on which server is to run, it should be a unique number that will not conflict with other running servers  
         public static void main(String args[]) throws Exception{ 
            ServerSocket welcome = new ServerSocket(port);    // Initialize TCP/IP Socket Connection for accepting client requests. Port defined above     
             System.out.println("Server started on port: " + port );    
              while (true){  
                Socket connectionToClient  = welcome.accept();  // Accepts a new request from the connected Client   
                   PrintWriter out =new PrintWriter(connectionToClient.getOutputStream(), true);         
                    BufferedReader in =  new BufferedReader(                          
                         new InputStreamReader (connectionToClient.getInputStream()));  
                        String clientMessage;  // Declare variable to hold received message from Client    
                       if ((clientMessage = in .readLine()) != null) {    // Reads the Message sent by a specific User     
                            System.out.println("Received: " + clientMessage);       
                             out.println(processData(clientMessage));  // Sends back an encrypted version of received message to Client       }   catch (IOException e){e.printStackTrace();}}    Connection is closed at the end}      }}