import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.x509.*;

public class java_51213_SocketServer_A01 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket();  // Create a socket on port 80 and become passive (listening).  
        
        try {                
            while (!server.isClosed()) {      
                Socket clientSocket =  server.accept();     // Wait for incoming connection requests...   
              
                    System.out.println("Client connected from " +clientSocket); 
                    
                  BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));  
                   PrintWriter out= new PrintWriter(clientSocket.getOutputStream(), true);     // Send response to client over this socket...   
                 Cipher cipher;                      //Cryptography operations are done using the KeyGenerator object's generateKey() method     
                  Key key = KeyGenerator.getInstance("AES").generateKey();   // Generate an AES-key  ...        
                   String encrypedText="";   
                 byte[] encryptedByteArray;    
                cipher  = Cipher.getInstance ("AES");         
               try {       
                    cipher .init (Cipher.ENCRYPT_MODE, key);       // Initialize the encryption      ... 
                  InputStream is= clientSocket.getInputStream();   //Read input from socket and encrypt it...   
                   BufferedReader br = new BufferedReader(new InputStreamReader((is)));    
                 String line;          
                while ((line  =br.readLine()) !=  null){ 
                  encryptedByteArray= cipher .doFinal (line.getBytes() );          //Reads the input...    Encrypt it and send back to client..   ...        }         finally {      serverSocket.close();}}       catch(Exception e) {}              in.close();            out.close():
               })  };                     System.out.println ("Waiting for Clients"); }}catch (IOException ex){ // Close the socket and end process if an error occurs...   }                    clientSocket . close()};}                   });}}                  catch(Exception e) {e.printStackTrace();}}}`