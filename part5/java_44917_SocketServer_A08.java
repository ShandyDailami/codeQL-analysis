import java.io.*;
import java.net.*;

public class java_44917_SocketServer_A08 {    
    public static void main(String[] args){      
        try{          
            ServerSocket socket = new ServerSocket(4242); // Listening port for incoming connections         
             System.out.println("Waiting connection on " +socket.getLocalPort()+"..." );        
             
             Socket partnerSocket= null;    
               while (true) {     
                  try{      
                     partnerSocket = socket.accept();   // Accept a new client         
                      System.out.println("Connected to " +partnerSocket.getRemoteSocketAddress());        
                       DataInputStream inFromClient =new  DataInputStream(partnerSocket.getInputStream());   
                            String message=inFromClient.readUTF();      
                              // Do something with the received data...        println for example         
                               System.out.println("Received: " +message );        
                      }catch (IOException ex){            Logger.getLogger(A08_IntegrityFailureServer .class.getName()).log(Level.SEVERE, null ,ex);   // handle any io exceptions        break;    
                  }      
               }     
          } catch (IOException e) {         System.out.println("Could not listen on port " + socket.getLocalPort()+".");   
              e.printStackTrace();  }}           
}