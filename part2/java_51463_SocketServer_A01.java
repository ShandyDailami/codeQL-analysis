import java.net.*;
import java.io.*;
  
public class java_51463_SocketServer_A01 {    
    public static void main(String[] args) throws IOException{      // Step 1a, start of 'main' method with step d and f         
        ServerSocket server = new ServerSocket();                   // Creating a socket on port number (default is system assigned).      
        
            int clientNumber = 0;                                  // Start counting clients.    
            
              while(true){                                         // Step 1b, start of infinite loop for accepting multiple connections         
                  try{                                             // Accepts an incoming connection from a single client                
                      System.out.println("Waiting for Client number: "+clientNumber);    // Display message to confirm that the socket is up and running               
                      ++clientNumber;                                   // Increase count of clients 
                   Socket s= server.accept();                         // Create new 'Socket' object with accepted connection     
                      System.out.println("Connected client number: "+(clientNumber));    // Display message to confirm successful handshake                
                       DataInputStream dis =new    
DataInputStream (s.getInputStream());                        /* Step 1c, start of input stream         */                 
                   BufferedReader br= new     
BufferedReader       ((InputStreamReader   s . getInputStream()));    // Create a 'Buffer Reader' object for receiving data          
                      String clientMessage;                          // Variable to hold incoming message       
                       while((clientMessage = dis.readLine()) !=  null){                  /* Step 1d, start of loop until the end is reached   */                  
                           System.out.println("Client says: " +    (clientMessage));       // Display received client Message         
                      }                                                    /* End receive message from Client*/       
                       s.close();                                         // Close connection after use          
                  }catch(IOException e){                                     // Catch Exception if something goes wrong      try-except block   */    
                        System.out.println("Error: " +e);          // Display error details when exception is caught        
                 }                                                            /* End of catch statement*/      
              }                                                                  /* end while loop for accepting multiple connections    */       
            server.close();                                        // Close the ServerSocket after use  
      }    
}                                  /*End main method with step e and f*//