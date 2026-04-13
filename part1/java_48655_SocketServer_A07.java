import java.io.*;
import javax.net.ssl.*;
import java.util.Arrays;
import java.security.cert.*;
  
public class java_48655_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket("localhost", 12345);            
         
        while (true){                    
            try {                        
                SSLSocket clientSocket =  (SSLSocket)serverSocket.accept();                 
                
              // Handshake starts here                      
               KeyStore keyStore = KeyStore.getInstance("JKS");                     
               char[] password  = "password".toCharArray();                   
            
            try {                    
                keyStore.load(getClass().getResourceAsStream("/keystore"),                       
                 password);                                                          
              } catch (Exception e) {}  //Handling the exception if any                  
               SSLSession sslSession = clientSocket.createSessionID(keyStore,                   
                  new X509Certificate[] {clientSocket.getRemoteCertificate()});            
               
            BufferedReader in =                                                      
              new BufferedReader (new InputStreamReader                       
          (   clientSocket . getInputStream()));                                  //Reading the message from a connected user   
               String line;                                                                     int length=0 ;                     char[] buffer = new  byte[128];                       while (!((line=  in.readLine()) == -1)) {                  System.out.println("Received Message: " +          +"");             if (length == 0)  
               for(int i = 0;i < line . length(); ++a  )     //Checking the first message sent by      user                      buffer[++l] =line [1]; l=  }buffer.toString () ; System..println ("Server: " +           +"");}catch (IOException e) {}
   finally {                       clientSocket    ..close()};}} catch(SSLHandshakeException  ex){System . out . println("Error in SSL HandShaking...");ex             try{clientSocket.close(); }         catch          //closing the socket if an exception occurs           (IOException e) {}     finally {serverSocket.. close () ; }}
    -}   /*}}}}'  It should be noted that this is a very simple and insecure implementation of Socket Server for demonstration purposes only, as it does not include any form of encryption or authentication. In real-world applications more secure methods would need to take place (like using SSLCertificate based on mutual assured