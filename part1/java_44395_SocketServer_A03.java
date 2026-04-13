import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;  // for SecretKey creation, it's required by Cipher class java_44395_SocketServer_A03 KeyGenerator interface

public class SecureSocketServer {  
    private static final String ALGORITHM = "AES";    
      
    public static void main(String[] args) throws Exception{       
          ServerSocket serverSocket= new ServerSocket();  //Create a socket with port number above 128 (default), this will be our TCP listener.  
         try {                         
              System.out.println("Waiting for client on port "+serverSocket.getLocalPort() );   
              
            Cipher cipher = Cipher.getInstance(ALGORITHM);  //Create a new instance of the AES key generator and get reference to it      
             KeyGenerator kg = KeyGenerator.getInstance("AES");   //Generate an APIKey object using default keysize (128 bit)       
              SecretKey secretkey =  kg.generateKey();        
            cipher .init(Cipher.ENCRYPT_MODE,secretkey);      
             byte [] encryptedMessage = null;    
               BufferedReader inStream= new BufferedReader(new InputStreamReader (serverSocket.getInputStream()));    //Accept incoming client connection  
              DataOutputStream outStream =null ;                  
            while(true) {                   
                  String message, response;         
                Socket socketConnection =  serverSocket .accept();    
                 System.out.println("Received request from port "+socketConnection.getPort());    //Read incoming client data            
                      inStream=new BufferedReader (new InputStreamReader(socketConnection.getInputStream()));   # Get input Stream for Reading message  and write response back to the sender      
                     DataInputStream dis = new DataInputStream((socketConnection.getInputStream()));      Reader reader =  null;        // Read data from a client socket         
                   BufferedWriter out=new BufferedWriter(new OutputStreamWriter (socketConnection . getOutputStream()));    # Send message     AES encrypted back to the sender      
                  while ((message = inStream.readLine()) != null) {      PrintWriter writer =  new PrintWriter((Socket ) socketConnection.getRemoteSocket(),true);   True if this connection is currently used by any thread then releases it         out .println(cipher.doFinal ( message.getBytes() )));         
                      }                            // Close the connections and release resources             cipher = null;              writer=null;}     socketConnection  = serverSocket   `enter code here`  `socket Connection close successfully on port `+server_socketsocket . getLocalPort());} catch(Exception e){e.printStackTrace();}}