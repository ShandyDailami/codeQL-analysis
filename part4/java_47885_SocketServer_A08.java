import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47885_SocketServer_A08 {  
    private static final String ALGORITHM = "AES"; // AES is a standard algorithm for encryption and decryption of data in general case it's secure enough here 
    
    public static void main(String[] args) throws Exception{      
        ServerSocket server= new ServerSocket();        
        System.out.println("Server started");            
         
        // AES key is generated for encryption and decryption of the data while receiving from clients     
        Key key = generateAESKey();    
          
        int clientNumber = 0; 
   
       do{           
         server.accept();  
               System.out.println("Client "+ (clientNumber++) +" connected");                
            
              SocketHandler(server,key); // create socket handler for handling each connection separately         
           }while(true);    
        }     
       catch(Exception ex){        
            System.out.println("Server error: "+ex );   
                  server.close();   ))));}`;