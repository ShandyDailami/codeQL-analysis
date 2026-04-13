import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
  
public class java_49083_SocketServer_A07 { 
      
    public static void main(String[] args) throws Exception{     
        SSLServerSocket serverSocket = null ;    
          
            try {            
                KeyStore keyStore =  KeyStore.getInstance("JKS");        
                    InputStream inputStream  = new FileInputStream("/path_to/yourkeystorefile")  ;   //change the path      
                     String storePassword   = "password"                        ;      // change password when needed    
                      int port          = 8443;       
                keyStore.load(inputStream,storePassword.toCharArray());        
                   SSLServerSocketFactory sslServerSocketfactory =  
                  (SSLServerSocketFactory)SSLServerSocket.getDefaultSSLSocketServerFactory();      
            serverSocket=    (SSLServerSocket)sslServerSocketfactory .createServerSocket(port);      // create new socket on given port    
                   HSSFSSLServlet sslservlet =new  SSLComponent() ;                  Thread thread  =null;  
                      while(true){       char  buffer[]   =new    char[1024];        int bytes=serverSocket.accept();      // accept incoming connection         String hostname =  serverSocket .getInetAddress().toString ()                System.out.println ("Accepted new client : "+hostname);          
                          SSLSocket sslclient  =(SSLSocket)sslServerSocketfactory   .createSocket(bytes, socketReadTimeout ) ;     // create a newly created socket and bind to an incoming port      BufferedReader inFromClient =null;            try{              InputStreamReader isr= new  InputStreamReader ( bytes , "UTF-8");            
                      DataOutputStream outToClient  =new       PrintWriter(bytes ).out    ;               //set up outputstream          Thread.sleep(10);                     } catch     Exception e { System .err ..   printStackTrace();}      if(!sslservlet."  init ( sslclient , serverSocket ) && ! "