import javax.net.ssl.*;
import java.io.*;
import java.util.*;
import java.net.*;
   
public class java_43462_SocketServer_A07 {
     private static final String PASSWORD = "password"; // hardcoded password for simplicity, use a secure method in real application  
     
     public void start() throws IOException{ 
         SSLServerSocket serverSocket =  null;         
           try{           
                KeyStore keyStore=KeyStore.getInstance("JKS");   
              InputStream inputStream = new FileInputStream("/path/to/yourkeystorefile") ;   //replace with your keystore file path    
               char[] passwordArray  = PASSWORD .toCharArray(); 
                keyStore.load(inputStream,passwordArray);       
            SSLServerSocketFactory sslServerSocketfactory = new SSLServerSocketFactory(keyStore)    ;            
              serverSocket =  (SSLServerSocket)sslServerSocketfactory.createServerSocket(8012 );           // you can change port number here  
               while(true){ 
                   Socket clientSocket=serverSocket .accept();    
                    System.out.println("Client IP:"+clientSocket.getInetAddress().getHostAddress());   
                     SSLSocket sslSock = (SSLSocket) serverSocket.accept();        //SSL/TLS socket creation           
                      BufferedReader in=  new BufferedReader(new InputStreamReader((sslSock.getInputStream()))) ;       //input stream reader            
                       String clientQuery;        
                        while ((clientQuery =in .readLine()) != null){   System.out.println("Client Query:"+clientQuery);    }  if(!PASSWORD.equals(requestPassword())){               throw new AuthFailureException();}     //authentication mechanism for password            else {           /*do something*/         }}catch (Exception e) {e .printStackTrace()};      
                   clientSocket.close();      sslSock.close();  serverSocket.close();   }}}          catch(IOException i){i . printstacktrace}    finally{serverSocket?.close();}}}`;     //closes all the connections at end of execution        try {start (); /*if you want to run in thread*/ }}catch(){System ..println("Error while starting server");}) ; 
             }   Class used for exception handling is java.lang package, so no imports necessary here except IOException from Java's standard library classes and AuthFailureException which comes with javax security packages or it can be created by the programmer if not already exists in classpath. This implementation assumes that you have a keystore file to use SSL/TLS for encrypting connections on port 8012, replace "/keystoresample" inside FileInputStream line above and pass "password", then start your server with command: java -cp . SecureServer