import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_51426_SocketServer_A07 {
    private static final String ALGORITHM = "AES"; // The symmetric encryption algorithm we'll be using for data transmission security 
  
     public static void main(String[] args) throws Exception{       
         ServerSocket serverSocket= new ServerSocket();     
           System.out.println("Server is running on port :"+serverSocket);               
            Socket socket = serverSocket.accept();    //Accepts incoming client request              
            
              DataInputStream dis =new DataInputStream(socket.getInputStream());  /* Input Stream for Reading Client Requests */  
        	  String message=dis.readUTF();           System.out.println("Client says :"+message);       
            Key key1 = new SecretKeySpec(message.getBytes(),0,message.getBytes() , ALGORITHM );  /* Encryption/Decrytion of Message */   //This is AES with the message as a secretkey       System.out.println("Using "+ALGORITHM +" algorithm");     
           Cipher cip =Cipher.getInstance(ALGORITHM);            cip .init(Cipher.ENCRYPT_MODE , key1 );  /* Encryption operation */    //Encrypted using same SecretKey for decrypting the message     System.out.println("Decrytion mode "+cip +" initiated");     
           byte[] enc= cip .doFinal(message.getBytes());          DataOutputStream dos = new DataOutputStream (socket.getOutputStream()) ;    /* Out Stream to Write Server responses */   //Writes encrypted message on the socket     System.out.println("Encrypted Message: "+enc);     
           dos.writeUTF(new String( enc ) );  doos .flush();                  serverSocket.close();                }         catch (Exception e){System.out.print ("Server error :" +e) ;}          }}