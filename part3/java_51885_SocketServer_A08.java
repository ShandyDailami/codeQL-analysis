import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   // for Cipher Symmetric Key generation and operation
import org.apache.commons.codec.binary.Hex;    // For Hashing the Received Data 
    
public class java_51885_SocketServer_A08 {      
        
        private static final String TRANSPORT_PROTOCOL = "TLSv1";   // Security Protocol Version (SSL/ TLS) to use for communication over socket.                
            
            public static void main(String[] args){          
                ServerSocket serverSocket; 
                     try {                   
                         System.out.println("Starting the SocketServer...");                  
                          // Create a new listening port (e.g.,8096)   
                         int servingPort = 54321 ;            
                         serverSocket =new ServerSocket(servicingPort );  
                             while(true){                   
                                 System.out.println("Waiting for client to connect...");    
                                  Socket theClient=serverSocket.accept();         // Accept incoming connection requests   
                                   System.out.println ("Connected from: "+theClient.getRemoteSocketAddress());  
                                    DataInputStream dis = new  DataInputStream(theClient.getInputStream()) ;     
                                     String receivedData;          
                                         do{                  
                                              byte [] bufferSize=new byte[1024];    // Buffer for Received data           
                                             int bytesNumRead=dis .read (bufferSize);          }while(bytesNumRea   d > 0 );               while ((receivedData = dis.readLine()) != null){                  String originalHash =  receivedData;             System.out.println ("Original Data: " +originalHash) ;
                                           Cipher cipher=  Cipher.getInstance("AES");                SecretKey secretkey  =  new SecretKeySpec(Hex.decode("your_16Byte-SecretKEY"),"AES")  //Use the same key for encryption and decryption    while (bytesNumRead > 0) {              
                                              byte [] bufferSize=new byte[1024];                   int bytesNumRead = dis .read(bufferSize);                 String receivedDataAfterDecrypt =  new String   (cipher.doFinal((byte[] )receivedData),"UTF-8");          System    tim  println("Received Data After Decryption: " +      
                                              receivedDataAfterDecrypt );}               cipher .init(Cipher.DECRYPT_MODE, secretkey);}}catch (Exception e){                   //Close the resources                    if ((theClient != null)){                     try {         theClie    nt.close(); } catch   (IOException ex) 
                      {}           System.out.println("Connection closed by client");}             serverSocket .close();}}}                 Catch block to handle exceptions              SocketServer: An error occured when trying ti establish a connection with " + theClient, e);}}catch(Exception E){System   out    println ("Error in Connection establishment"+E.getMessage())