import java.net.*;
import javax.net.ssl.*;
import java.io.*;  // for Input/Output Streams and Serializable objects  
public class java_50076_SocketServer_A07 {   
     public static void main(String[] args) throws Exception{       
         SSLServerSocket sslserversocket = null;     
          try      
           {           
             KeyStore keystore = KeyStore.getInstance("JKS");              // Initialize the keystore 
               InputStream keystoreInputStream =  SocketServer.class    .getResourceAsStream("/path/to/yourkeystorefile" );  
                keystore.load(keystoreInputStream, "mypassword".toCharArray());      
             KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI");      // Initialize the keymanagerfactory  with our Keystore and password    
                 kmf.init(keystore, "mypassword".toCharArray());   
                sslserversocket= (SSLServerSocket) new SSLServerSocket(54321 ,kmf);              // initialize server socket at port number       if there is any exception thrown during initialization then print the stack trace           catch  { e.printStackTrace(); }         finally{sslserversocket .close();}}         
             while (true){            Socket s= null;                try     
               {                        s = sslserversocket.accept( );              // Accept a new socket from client       if there is any exception thrown during the execution of this block then print stack trace     catch 
                 { e .printStackTrace(); }   continue;}           DataInputStream dis= null;            try     
               {                          dis =new DataInputStream (s.getInputStream());              // Get an Input Stream from socket       if there is any exception thrown during the execution of this block then print stack trace     catch 
                 e .printStackTrace(); }   continue;}           System.out.println ("Client Connected");            try     
               {                  String str= dis.readUTF ();              // Read a UTF string from socket       if there is any exception thrown during the execution of this block then print stack trace     catch  e .printStackTrace(); }   continue;}             System.out.println ("Server Received : "+str );}         finally{s.close();}}