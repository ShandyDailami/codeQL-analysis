import java.io.*;
import javax.net.ssl.*;
import java.util.*;
import com.sun.security.auth.callback.*;
import org.apache.commons.codec.binary.Base64;
public class java_53069_SocketServer_A07 {  
    private static final String CLIENT_KEY = "src/main/resources/client-key.pem"; // Path to your client key file 
    private static final String SERVER_CRT =  "src/main/resources/server-certificate.pem" ;//Path for the server certificate  
      
      public BufferedReader inFromClient;    
        SSLServerSocket sslServerSocket = null;        
          try {            System.setProperty("javax.net.ssl.keyStore",CLIENT_KEY);            
              //Creating a new Server Socket at port 8095 (you can change it)          
                sslServerSocket=(SSLServerSocket)new SSLServerSocket(port,null,(SSLContext) SSLServerSocketImpl.getDefaultSSLServerContext());  
                  System.out.println("Waiting for client on port: "+sslServerSocket.getLocalPort() );      
                     while (true){                       Socket sslSocket = null;  //Accepts incoming connection from Client                try {                        SSLSocket sslsocket=(SSLSocket)sslServerSocket.accept();                      System.out.println("Connection accepted");               BufferedReader inFromClient  = new BufferedReader   (new InputStreamReader   
     sslSocket.getInputStream()));      //Reads the message from client            String ClientMessage;           try {                while ((ClientMessage =inFromClient .readLine()) != null)  System.out.println("Received: " +       CLientmessage);                     } catch (IOException e){e.printStackTrace();}
               finally{sslSocket.close();}}   //Closes the socket connection     sslServerSocktemnET"             if(true)}                 else {System .out    .println("Unable to establish secure SSL/TLS Connection, Server exiting"); System exit (0); }}}}