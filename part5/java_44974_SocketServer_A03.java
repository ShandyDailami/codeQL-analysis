import java.io.*;   // For serializable class java_44974_SocketServer_A03   
import java.net.*;     // for ServerSocket, Socket classes      
public class VanillaServer { 
 public static void main(String[] args) throws Exception{     
        int port = 4567;         
         @SuppressWarnings("resource")   // This resource will be closed at the end of this block.     ServerSocket, Socket and BufferedReader are automatically managed by Java's garbage collector   
       ServerSocket server = new ServerSocket(port);     
        System.out.println("\nServer Started on port: " + port );  // To know when a client connects  
          
         while (true) {         
             Socket sock=server.accept();     //Waiting for incoming connection   
               try{           
                   BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));  /* Read from socket */     
                          String msg;  
                           while ((msg = in .readLine()) != null) {     //Read the message sent by client       }           catch (IOException e){e.printStackTrace();}          System.out.println("Client says: " + msg);        }}  /* If any exception occurs */catch(Exception ex){System.err.println("# Exception Occurred #"+ex) ;};  
    }}} // end of main function       }//end class VanillaServer    });}};