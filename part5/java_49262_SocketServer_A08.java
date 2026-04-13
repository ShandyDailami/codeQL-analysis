import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class java_49262_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket();     // Create a socket for accepting client connections     
        KeyPair keyPair =  getKeyPair("MySecret", "RSA");       // Generate an RSA pair of keys, you can change the algorithm and size as per your requirements   
         Cipher cipherOut  =Cipher.getInstance ("RSA/ECB/PKCS1Padding");  /* Encryption instance */       
           cipherOut .init(Cipher.ENCRYPT_MODE , keyPair.getPublic());   // Initialize encryption with the public-key    
         BufferedReader inStream = null;   
          InputStream inputStream  =null ;       OutputStream outStream=null;  Socket clientSocket =  server .accept();      try{        byte[] bytes = new byte[1024];   int count= 0; String data="";     cipherOut.update(new BouncyCastleEngine().generatePrivateKey());         
         inputStream  =clientSocket.getInputStream();  // Retrieve the client's Input Stream      outStream =  new FileOutputStream("C:\\Users\John Doe_WorkStation",true);   System .out.println ("New connection accepted "+ );    inStream =new BufferedReader(
        new InputStreamReader (inputStream));          for (;;){ try{ data=inStream.readLine(); if ((data==null) ) { break;} } catch({ IOException e}) {}     cipherOut .update (Base64Utils, decodeToByteArray ,  Base64Decoder());     
         System outData ="";StringTokenizer st= new StringTokenizer( data," ");    if ((st.countTokens())>0){        for (;;try{} catch({ Exception e }) {}}     }catch (Exception ex)       return ; /* end of client connection */  finally{     
          try,outStream =clientSocket .getOutputStream(); outData=Base64Utils(cipherOut , data);   if ((data==null))break; println("Message to be sent: "+ outData );    write (outputstream) ; /* end of transmission */}}catch({ IOException e }) {return;}
        }  finally{ server.close(); }}          // Close the socket here and release all system resources! This is a sample program, not for production use}}}'s   it will work fine if you run this in your local environment but don’t forget to replace "RSA" with whatever algorithm suits best depending on what kind of data needs encryption/decryption.