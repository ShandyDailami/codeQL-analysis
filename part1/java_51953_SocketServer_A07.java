import java.io.*;
import java.net.*;

public class java_51953_SocketServer_A07 {
    private static final String SERVER_STATE = "SERVER"; // State of server to indicate client is authenticated or not after login attempt from a user
    
    public static void main(String[] args) throws IOException{ 
        ServerSocket welcomeSocket= new ServerSocket(6013);  
         System.out.println("Waiting for Client on Port: "+welcomeSocket);     
          while (true){            
            Socket connectionSocket= welcomeSocket.accept();       // Wait till a client connects to server  and then accept the request from that socket       
              try{  
                System.out.println("Connected with Client");    
                  DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());   
                    String userInput=inFromClient.readUTF();// reading data sent by client  for login attempt     
                      if (userInput != null && SERVER_STATE.equalsIgnoreCase(userInput)) { //checking the input string with server state  
                        System.out.println("Authentication Successful");    
                          DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
                            String responseMessage =  "Login successful";   
                                outToClient .writeUTF (responseMessage);//sending login success message back to the client   } else { // if failed authentication, send error and close connection}        
                    Connection closed...     inFromClient= null;      DataOutputStream  outToClient =null;}                 try{connectionSocket.close();}} catch(IOException e){e.printStackTrace();}}}//End of main function        finally{{try {welcomeSocket .close (); }catch (IOException e) {{E O bst, the server is shutting down...