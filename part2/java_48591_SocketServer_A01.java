import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_48591_SocketServer_A01 {   // Server side socket programming starts here (Client - server communication)
    public static void main(String args[]){ 
        int port = 1234;     
         Cipher cip = null ;     /* Create a default instance of the provider named "SunCipher" */      
           try {   //initialize cryptographic tools and setup server-side socket communication.   
                Key key=new SecretKey();  // generate secret keys for encryption/decryption example purpose only, in real world application use SSL certificate to ensure secure communications     
               cip = Cipher.getInstance("AES", "SunCipher");     /*Get an instance of the named algorithm */  
              cip.init(Cipher.ENCRYPT_MODE , key);  //set mode and Key for encryption   
             ServerSocket serverSock= new ServerSocket(port) ;      //Initialize a socket to listen on port number specified by user at creation time, in this case we use the hard-coded value of '1234'   };     catch (Exception e){ System.out.println ("Error while initializing server: " +e);};
           }  finally { cip = null; // Ensure resources are always released when done with them, in this case only the key so we can use it again later}}   
        try{     /* Incoming connection - handle incoming connections */      Socket sock= serverSock.accept();   System.out.println ("Connection accepted from " +sock.getRemoteSocketAddress());  //handle outgoing socket communication for the client, in this case only print a message on screen
        try{    BufferedReader br = new BufferedReader(new InputStreamReader ( sock.getInputStream()));   /* Create an input stream to read from server */      String line=null;     System.out.println ("Waiting for password");  //wait until user enters a string on the client side
        try{    cip = Cipher.getInstance("AES", "SunCipher") ;       Write in response by entering pass_word:   /*Decrypt data */      String pwd= br . readLine();     System.out.println ("Password entered was :"+pwd);  //compare the encrypted password with user's input, if it matches then continue else break and end program
            cip.init(Cipher.DECRYPT_MODE , key );    Cipher copycip = cip . createChainCopy();   /*Decrypt received data */      byte [] decryptedByte=copycip.doFinal (Base64.decode(line));     String strDecoded = new String(decryptedByte);  System.out.println ("Received password: "+strDecoded) ;
        }catch{    e . printStackTrace(); };   // if exception occurs capture it and log the error, finally block is called at end of try-catch only when a statement in catch was thrown or an uncaught checked Exception causes method to terminate  cs sock.close ();     System.out.println ("Connection closed");
    }};   // End Server Side Socket Communication starts here}))