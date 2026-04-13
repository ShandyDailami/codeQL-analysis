import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.bouncycastle.util.*;
//...other necessary imports 
public class java_52754_SocketServer_A03 {  
    private static final String PASSWORD = "password"; //Password for encryption/decryption, use it with caution and replace this by your real password later on if required        
    
    public static void main(String[] args) throws IOException{      
        ServerSocket serverSock= new ServerSocket(8092); 
           System.out.println("Waiting for Client connection..."+serverSock );         
               Socket clientSock = serverSock.accept();              //Accepts the request from a connected socket           
             PrintWriter out=  new PrintWriter (clientSock.getOutputStream(),true);                   Output Stream: Send acknowledgment to 		 Client   	    	 					     				      			                System.out .println ("Connection established!" );                  try {                      //Encryption part                     Cipher cip=Cipher.getInstance("AES");//Replace with your real algorithm if required             
            Key key = new SecretKeySpec(PASSWORD.getBytes(),0, PASSWORD.getBytes() , "AES"  ) ;             System.out .println ("Using AES encryption...");                     //Use BouncyCastle or any other library for decryption                    Cipher cipin=Cipher.getInstance("AES");//Replace with your real algorithm if required             
            cip.init(Cipher.ENCRYPT_MODE, key );                         System .out   .println ("Encrypted Connection Established!");                  BufferedReader inFromClient = new 		      					          	BufferedReader (clientSock.getInputStream());                   String clientMessage;                     while ((clientMessage=inFromClient.readLine()) != null) {//Reads a line of text from the socket and decrypt it using AES                   
            cipin .init(Cipher.DECRYPT_MODE, key );                         System 		      					  		.out   				    			                   (".Decrypted Message: " + clientMessage);                     }                      //closes streams          out.close();clientSock.close():              
        catch {             if (!(socket instanceof ServerSocket)) throw new IOException("Not a server") ;  System .exit  0;      }} finally{ socket	.close ()}//Closes the sockets in any case}                  }catch{}finally {}                   //main method ends here                    });    }, e);