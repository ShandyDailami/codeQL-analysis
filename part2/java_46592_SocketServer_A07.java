import javax.net.ssl.*;
import java.io.IOException;  
import java.io.InputStream;   
import java.io.OutputStream;     
import java.net.ServerSocket;    
import java.net.Socket;           
      
public class java_46592_SocketServer_A07 { 
         private static SSLServerSocket serverSocket = null ;          // Server socket          
            
        public void start(int port) throws Exception   
                {                 
                 try{     
                    KeyStore keyStore=KeyStore.getInstance("JKS");    
                      InputStream in=  SocketAuthFailExample.class  .getResourceAsStream("/serverkeystore.jks") ;   // path of the keystore file          
                     keyStore.load(in, "mypass".toCharArray());   
                       KeyManagerFactory kmf = new JKSKeyManagerFactory (keyStore,"mypass".toCharArray() );    
                      SSLServerSocketFactory sslserv=new  SSLServerSocketFactory(kmf);           // Server socket factory with key manager         
                     serverSocket=  (SSLServerSocket)sslserv.createServerSocket(port);         // create the listener           
                        }catch (Exception e){ System.out.println("Could not listen on port: " + port );    throw  e ;}     
                          while(true){                  try{     Socket client=serverSocket .accept();          OutputStream out=  client   .getOutputStream() ;                   // get the output stream from socket         ... continue as before ....             }catch (Exception e) { System.out.println("Client Accepted: " +client);  break;}}   
                public static void main(String args[] ){     try { SocketAuthFailExample server=new   SocketAuthFailExample();server .start(4044 ); }catch (Exception e){ System.out.println("Server Startup failed");}        while(( true));  }}