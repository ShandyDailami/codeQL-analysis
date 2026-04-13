import java.io.*;  // for Input/Output streams, BufferedReader etc..
import java.net.*;  // For ServerSocket & Socket class...
import javax.crypto.*;   //for SecretKey and Cipher instances....
import javax.crypto.spec.*;    //For secret key specification (AES).....

public class java_53238_SocketServer_A08 {
     static final String ALGORITHM = "AES";  // or use RSA, DSA etc... in production code..  
     
     public static void main(String[] args){      
         ServerSocket serverSock=null;    //declare a variable for the socket object to be created at runtime.       
          try{            
              System.out.println("Starting SecureServer");              
                      
                      /* Create an SSL context */  
                 Cipher cipher = Cipher.getInstance(ALGORITHM);      //create a new instance of the AES algorithm.... 
                          Key key=KeyGenerator();                     // generate secret keys...                   
                         serverSock =  new ServerSocket(5098,1234567) ;    /* Create an endpoint at port  = 5098 */     
                       while (true){      
                           System.out.println("Waiting for Client on Port 5098...");          // wait till a client connects.......                  
                          Socket sock= serverSock .accept();            /* Accepts incoming connection from the socket port*/        
                            System. out. println ("Connected to " +    (new java.util.Date())+ "\n");  /print time when connected/         
                       // Read Message and decrypt it......           Cipher cip=Cipher .getInstance(ALGORITHM);                 
                           DataInputStream dis = new   DataInputStream ((sock.getInputStream()));     /* create a data input stream */                PrintWriter pw=  null;    try {pw =  new  PrintWriter ( sock . getOutputStream(), true );} catch.../catch block..              /print time when connected         
                           // send encrypted message....      cip.init(Cipher.ENCRYPT_MODE,key);     String str= dis   .readUTF();           pw.println  ("Server : " + encryptData (str));        }         catch.../catch block..                    /print time when connected         
                      //close the connection and exit from loop if a client abruptly disconnects........      sock. close() ;     System   . out    . println("Connection closed at:  "+ new java.util.Date());                                                     } catch (Exception e) {e.printStackTrace();}}
         //catch block for the exception..             SocketExcepti ons, serverSock =null;System ..println ("server socket failed to listen on :  5098"+ "\n");  if(socket != null){try{socker . close ();} catch.../the best way is to reuse the same sockets.