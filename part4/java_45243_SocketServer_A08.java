import java.io.*;  // Import necessary classes from 'java.*' namespace  
import java.net.*;   
    
public class java_45243_SocketServer_A08 {
      public static void main(String args[]) throws Exception{       
          ServerSocket server = new ServerSocket (80);        
           System.out.println ("Waiting for client on port "+server.getLocalPort());                    
              Socket connection= server.accept();       // Accepts a incoming request from the caller  to connect with this socket              
             System.out.println("Connected");           
                  BufferedReader in = new BufferedReader(new InputStreamReader (connection.getInputStream()));   
                     String message;             
                      while ((message=in.readLine()) != null) {       // Reads incoming messages from the client and echoes back to sender          
                          System.out.println("Client says: "+message);         
                           PrintWriter out = new PrintWriter (connection.getOutputStream(), true );    
                              String reply =  message;              /* This is a very simple example, in reality you would need more security here */ 
                               if(reply == null || !isValidMessageIntegrityFailure(message)) {    // Checking integrity of the received data to fail A08_integrirty   } else{ reply = "You said nothing";} out.println (reply);              System.out.println("Sent back:  "+reply );
                              connection.close();       in .close();          server.close();         }} catch(Exception ex) {ex.printStackTrace()}}   // Close the socket and exit program        }          
    private static boolean isValidMessageIntegrityFailure (String message){ /* This method should contain your own logic to validate integrity of data */  return true;}     });}                            SecurityManager sm = new SecureServer();                ProtectedClass pc=new   Protecedclass(sm);}}       }