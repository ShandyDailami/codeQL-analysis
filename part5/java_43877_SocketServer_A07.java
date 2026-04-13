import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_43877_SocketServer_A07 {
    private static Key key; // symmetric encryption secret password    
      
   public static void main(String[] args) throws Exception{            
        ServerSocket server = new ServerSocket(5000); 
         System.out.println("Server is listening on port: " + 5000 + "\n");                
          while (true){                    
            Socket socketConnection =  server.accept();              
                // Start asynchronous task for each client request to receive & send data                     
                    new EchoProtocol(socketConnection).start();            
              }                 
           }   public static class EchoProtocol extends Thread {          private final Socket sock;  DecryptingInputStream dis;      EncryptingOutputStream eos ;    byte[] buffer =new byte[1024];        
        // Create an instance of encryption for receiving data from the client                 System.out.println("New connection " + socketConnection.getRemoteSocketAddress()+ "\n");            
          sock=socketConnection;                     Dispatcher dispatcher =  new Dispatcher(sock);     eos=  new EncryptingOutputStream (dispatcher, key );    dis =new DecryptingInputStream  (dispatcher ,key) ;           while ((read = is.read(buffer)) != -1){                   
             write(eos, buffer, read); }        // Close the connection and remove thread from list     eos.close(); sock.close();}         private static int read = 0;    try {  if((write =sock.getOutputStream().write(buffer)) !=  -1){}}catch (IOException ioe)            
                {}finally{          // If not connected, then stop the loop and remove thread from list        }      dispatcherlist .remove(this);}                 sockclose();    }} catch  Exception e {e.printStackTrace() ;}}}     System.out.println("Error in client connection ");}}