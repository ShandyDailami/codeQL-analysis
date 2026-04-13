import java.io.*;  // Input/Output Stream Class
import java.net.*;    //Socket Networking, including Datagram and Server Socket Classes  
    
public class java_44547_SocketServer_A01 {     
       public static void main(String[] args) throws IOException{          
              try (ServerSocket server = new ServerSocket(8091))  {               
                     System.out.println("Waiting for client on port " +server.getLocalPort() );              
                      while(true){                        
                             Socket socketConnection=server.accept();   //Accepts the incoming connection request from a clients computer                         
                              try{                  
                                     DataInputStream dataInStream = new DataInputStream (socketConnection.getInputStream());  //Read operation                 
                                      String clientMessage;                          
                                        while ((clientMessage = dataInStream .readUTF()) != null) {    /*Server waits for the incoming message from a Client */             
                                             System.out.println("Received: " + clientMessage);                                                  
                                         }   //Closing DataInputStream                       
                                      socketConnection.close();                           
                               } catch (Exception e){ 
                                       e.printStackTrace();                         
                                   }                    
                              }                      
                      }    /*End of While loop, end server*/                 
                             };                   
        }}                   */                                               //Closing Secure Server Socket