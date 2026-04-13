import javax.crypto.*;
import java.net.*;
import java.io.*;
  
public class java_49831_SocketServer_A08 {  // Start of example code snippet, lines a-e (A08_IntegrityFailure)
    private static final String SERVER_SOCKET = "localhost";     
    
    public static void main(String[] args){      
        ServerSocket serverSocket;  
         try {  // Avoiding Exception in case of socket bind failure. (A06, Blocks on line b).         
             serverSocket= new ServerSocket("1234");     
            System.out.println( "Server started.");    
           while(true){   
              Socket sock =serverSocket.accept();  // Accept client connection (A08_IntegrityFailure)      
               DataInputStream in= new   DataInputStream(sock .getInputStream());     
                System.out.println("Client connected");    
             String message;    for (; ; ) {// Server Infinite Loop - A13,  blocks on line c-e (A08_IntegrityFailure).      
                      try{   // Reading data from the socket input stream and decrypting it using Cipher.getInstance("DES")(a)   
                          message = in .readUTF();     System.out.println ("Received: " +message);  if (null=="".compareToIgnoreCase(message)) {break;}      }   catch (IOException e){       // Error Handling, A09_ExceptionHandling block on line d-e   
                         PrintWriter out = new PrintWriter(sock.getOutputStream(), true );     System.out.println("Closing the connection");  sock .close(); return; } }}           catch (IOException e) {       // Error Handling, A09_ExceptionHandling block on line d-e   
                     if(!serverSocket.isBound() || ! serverSocket.getInetAddress().equals( InetAddress.getLoopbackAddress())){     throw new IOException("Error with listening port" + e);}}  }      finally {       // Closing the socket and terminating (A13, Blocks on line c).       
               if (!serverSocket.isBound() || ! serverSocket.getInetAddress().equals( InetAddress.getLoopbackAddress())){     throw new IOException("Error with listening port" + e);}}}  // End of the example code snippet (A06)   }}};