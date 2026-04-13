import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;

public class java_44426_SocketServer_A08 {
    private static final String HASH_ALGORITHM = "SHA-256"; // for integrity check, we use SHA 256 hash function  
    
    public static MessageDigest md;
      
    public static void prepareMessageDigest() throws NoSuchAlgorithmException {        
        md  = MessageDigest.getInstance(HASH_ALGORITHM);         
      }          
           
  // incoming message integrity check method  
     private boolean isValidPacketIntegrity (byte[] receivedData, byte[] expectedHash) throws NoSuchAlgorithmException {        
        return Arrays.equals(computeSHA256Hash(receivedData),expectedHash);         
      }             
           
    // compute SHA-2 hash method  
       private  byte [] computeSHA256Hash (byte[] data) throws NoSuchAlgorithmException {        
        md .update(data );            
           return md.digest();    
               
          }     
                  
 public static void main(String args [])throws IOException{    //Main function for the server 
       Socket socket = null;  
            try{             
                  ServerSocket serverSocket=new ServerSocket (8091);          
                 System.out.println ("Server started at port : "+serverSocket.getLocalPort() );              
                     while(true){                // looping for every new client socket connection                   
                           socket = serverSocket .accept();    
                            Thread t=new Thread(() -> { 
                                try{                     
                                    BufferedReader br =  null;                                          
                                        DataInputStream dis  =         new             DataInputStream (socket.getInputStream());             
                                          String msgreceived    =      dis .readUTF() ;                    // reading the message from client  
                                            byte [] receivedData =     msgreceived    .getBytes();                 
                                             prepareMessageDigest( );                    
                                                boolean integrityCheckResult =  isValidPacketIntegrity (dis. readAllBytes(),computeSHA256Hash("Initial Message"));                   // check if packet matches expected hash               
                                            System.out.println ("Received Packet : "+msgreceived);                           PrintWriter pw=null;                    try{ 
                                               socket .close();                            }catch (IOException e){System. out. println(e) ;}                         break;}                     catch    (Exception   e ) { System     .outprintln ("Error in connection execution" +      e)}})));          Thread       .sleep(10);             }}          
                 //  closing the socket at last       
                    if(!socket.isClosed())            try{         socketserverSocket               =null;   }catch (IOException ex){System out     .println ("Error in stopping of server" +ex) ;}      System    ..out println("Server Stopped");}} 
                  // closing the reader at last        if(!br.isClosed() )             try{ br = null;} catch(Exception e){   }               socket   =null;}}}            }}          };                    });       }, "" + args);     }) ;}                                           );                  `}}, "".split("")