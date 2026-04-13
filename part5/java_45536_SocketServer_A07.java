import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.x509.*;

public class java_45536_SocketServer_A07 {
    private static final String PASSWORD_SALT = "salt"; // Salts added for security 
    
   public void start(int port) throws IOException{
        ServerSocket server = new ServerSocket(port);     
         System.out.println("Waiting connection on Port: '"+server.getLocalPort()+"' ...");          
         
       while (true){           
               Socket socketConnection =  server.accept();            
                handleClient(socketConnection);                 
        }    
    } 
      private void handleClient(Socket client) {        
              try{                   
                      DataInputStream dis = new DataInputStream(client.getInputStream());          
                       String passwordFromClient=dis.readUTF();          // Read Password sent from Client           
                        System.out.println("Received: "+passwordFromClient);                    
                         byte[] decodedPasswordBytes =  Base64.getDecoder().decode((new String(Base64.getDecoder().decode( passwordFromClient))));          
                          String received_salt = new String (decodedPasswordBytes, 0 ,receivedPassWordLength,"UTF-8");          // Decoding the salt sent from client           
                           String hashedInputPasswordWithSalt  = getSHA256Hash(password + received_salt);   // Hashing password with a unique盐              
                            if (hashedInputPassword == storedHashedPassword){                         
                                     System.out.println("Authenticated");                   
                                    }else{                                           
                                         System.out.print ("Failed Authentication" );                     
                                        client.close();                                           return;        
                                      }} catch(Exception e) {             // In case of any exception               
                                             printStackTraceAndExit(e);                     try{client.close();}catch (IOException ex){}}  finally{}          }      void finalize() throws Exception    {}        public static void main(String args[] )throws IOException   {{       SocketServer server=newSocketServiocesr;server.start(1234);}}}