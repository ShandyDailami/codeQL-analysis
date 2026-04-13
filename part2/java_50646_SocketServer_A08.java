import java.io.*;
import java.net.*;

public class java_50646_SocketServer_A08 {
    private static final int port = 2345; // define your own Port here, I used a predefined one for demonstration purposes only!  
    
    public void start() throws IOException{ 
        ServerSocket server = new ServerSocket(port);        
       while (true) {            
            Socket socketConnection =  server.accept();           // waiting to get client connection                              
               System.out.println("Client connected");             
                DataInputStream inputStream=new DataInputStream(socketConnection.getInputStream()); 
                   try{                     
                        String data =inputStream.readUTF();      // read the message from Client  
                         if (data==null) return;                 // terminate client and server connection in case of null or empty string received      
                          System.out.println("Received: "+data);  Logical checks for A08_IntegrityFailure here, like data length validation etc., are omitted due to the complexity but can be added if needed                                          
                   }catch (IOException e){                       // exception handling in case of any problem during communication   with Client      
                        System.out.println("Error occurred while reading from client: "+e);  return;     
                    }}                     
        server.close();                                       // closing the Server socket and also terminate all active connections if needed                           
    }                                                         
     public static void main(String[] args) throws IOException {   new VanillaSocketServer().start();}            };             });