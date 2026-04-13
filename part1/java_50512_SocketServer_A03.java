import java.io.*;  // Import necessary classes from standard Java library  
import java.net.*;   
    
public class java_50512_SocketServer_A03 {      
      public static void main(String[] args) throws IOException{         
           ServerSocket server = new ServerSocket();             
         try {                 
             System.out.println("Waiting for client on port " +                     
                     server.getLocalPort()+"...");                // Get local IP address and listening socket                
               Socket connection=server.accept();     
            DataInputStream in = new DataInputStream(connection.getInputStream());    
             BufferedReader reader =  new BufferedReader (new InputStreamReader(connection.getInputStream())); 
              String clientMessage;    // Declare a variable to hold the received message from Client        
               while ((clientMessage=reader.readLine()) != null) {     
                  System.out.println("Received: "+ clientMessage);         
                   connection.shutdownInput();          
                } 
             reader.close();   // Close BufferedReader after use to free up resources       
              in.close();    /* After reading data from the socket, close it */    
            connection.close();         /* And then disconnect*/      
          } finally {                  server.close();}     
  }}`;