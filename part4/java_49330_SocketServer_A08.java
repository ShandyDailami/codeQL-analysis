import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_49330_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(8091);        
            while (true){            
                System.out.println("Waiting for client connection..." + "\n");                
              //Accept the incoming request from a client  and make it persistent by returning socket object    
               Socket sock=server.accept();     
                  
                  DataInputStream inStream = new DataInputStream(sock.getInputStream());            
                    DataOutputStream outStream = 
                      new DataOutputStream (sock.getOutputStream());           //Creating an Output Stream      
                System.out.println("Connection established!"); 
               String str=inStream.readUTF();                 
              Cipher cipher =Cipher.getInstance ("AES");            // Instance of the class for aes encryption  
             Key key =  new SecretKeySpec( "0123456789ABCDEF" , 0 );         // Using AES algorithm and default keys (should be secret)     c               .doFinal(str.getBytes());              String decrypted=new String();           for (;;) {
                byte b = inStream.readByte();            if (b==-1 ) throw new java.io.EOFException("Exceeded buffer limit");    // Reading from the input stream     Decryption cipher .update(bytes);  }               decrypted=new String(decryptCipheredBytes,"UTF-8") ;
                System.out.println ("Decrypted Message : " + "\n"+   encryptedMessage );            outStream.writeByte (b)                 //Writing the message to client             sock.close();  } catch (Exception e){System .err ->printStackTrace() }}                  server.close()))