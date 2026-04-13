import java.io.*;
import java.net.*;
import java.util.*;
  
public class java_51339_SocketServer_A07 { 
    private static final String PASSWORD = "pass"; // hard-coded password for simplicity of examples, change as per your needs in a real application using secure hash functions and salts etc...    
      
    public static void main(String[] args) throws Exception{  
        ServerSocket server= new ServerSocket(54321); 
          
        while (true){             
            Socket sock =server.accept();     
              
                BufferedReader inFromClient = 
                  new BufferedReader(new InputStreamReader(sock.getInputStream()));  
                  
                    String clientMessage=inFromClient.readLine();   
                        System.out.println("Received: " +clientMessage);    
                          if (!authenticateUserAndPassword(clientMessage)) {  //Authentification failure case here...        
                                PrintWriter outToClient = new PrintWriter(sock.getOutputStream(), true);  
                                    outToClient.println("Sorry, you are not authorized!");     
                            }    else{          
                                     PrintWriter outToClient=new PrintWriter(sock.getOutputStream(),true );    
                                      outToClient .println ("Hello client , You have successfully authenticated");      
                                  }  
                   sock.close();  // Close the connection        
                System.out.println("Closed Connection from Client ");            
        }}          ServerSocket server=null;           if(server!= null){                  try{serv_socket_.close()}catch (IOException e) {e.printStackTrace()}; }              };   //End of Main method    public static boolean authenticateUserAndPassword  (String clientMessage ) throws Exception