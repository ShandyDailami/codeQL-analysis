import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_52580_SocketServer_A08 {  
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{          
            ServerSocket server = new ServerSocket(80);          //Create a server socket on port 7246        
             while (true){                  /* Start the infinite loop */      
                Socket sock=server.accept();   //Accept incoming connection    
                    DataInputStream dis =  null;           /**Input Stream to read data from client*/   
                   DataOutputStream dos =null ;          /**Output stream  for sending acknowledgment back in response**/           
                 try {                     /* Set up input and output streams */     
                        MessageDigest md=MessageDigest.getInstance("SHA-256");     //Setup SHA instance        
                         dis  = new DataInputStream(sock.getInputStream());   /** Input stream from client to read data*/         
                          byte[] b =new byte[10];              /*Buffer for incoming messages */   
                           int bytesNumRead=dis.read(b);       //Reading the message  received by a clinet        if (bytesNumRead < 0) {           throw new RuntimeException("Lost connection to client"); }          else{             md.update( b ,  0, bytesNumRead );     
                                        byte[] digest =md.digest();                      /*Generate SHA-256 hash */     System.out.println ("Received Hash : " + DatatypeConverter.printHexBinary (digest));          //Send the received message to client         dos  = new DataOutputStream(sock.getOutputStream()); 
                                  try {                          /**Write response back*/              do{dos .writeBytes("OK" );}while((bytesNumRead = dis.read())>0); }catch (Exception e){System.out.println ("Error in sending message");}} catch (NoSuchAlgorithmException ex)    {ex.printStackTrace(); 
                      System.err.println( "Server: Could not find an appropriate algorithm" );}   finally{sock.close();}}} // Close the connection            }     end of while loop         server .close() ;}} catch (IOException e){e. printstacktrace ()                                               }}