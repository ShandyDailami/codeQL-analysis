import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_43530_SocketServer_A08 {
    private static final String KEY = "1234567890"; // Key for encryption and decryption, replace it with your own key
    
    public static void main(String[] args) throws Exception { 
        ServerSocket serverSocket = new ServerSocket();  
        
		// Binding to port or localhost (depending on situation). Here we're using a real IP address for simplicity. You should replace it with your own ip and use 'localhost'.   
		
	    Socket socketConnection=serverSocket.accept();  // Wait until client connects here    
        DataInputStream dis = new DataInputStream(socketConnection.getInputStream());  
	DataOutputStream dos =new DataOutputStream(socketConnection.getOutputStream());     
        
	//Encryption of data before sending and decrypting after receiving to prevent integrity failure (A08_IntegrityFailure)    //Replace it with your own encryption method if needed 
        String plainText=dis.readUTF();  	    	   
                byte[] enc = getCipher().doFinal(plainText.getBytes());         
	        dos.writeUTF(""+enc);     		           
         }      	 
    // Crypto related methods (replace A08_IntegrityFailure with your own integrity method) 
     private static Cipher getCipher() throws Exception {  	            	   
                Key key = new SecretKeySpec(KEY.getBytes(), "AES");          		        	     	       	 			        return Cipher.getInstance("AES"); }      				    }) ;}          });             	} 					     	});     }} );}});})));}}) ).close();}}}  	};