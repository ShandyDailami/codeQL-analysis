import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;
  
public class java_49467_SocketServer_A08 { 
    private static final int port = 12345; // Change to your desired port number, should not be the same as any other one already used by a server in reality due security reasons (Port numbers below 1024 are privileged and reserved for system use).  
                                           // This is just an example. In real production scenarios you will probably want more than this amount of ports to ensure maximum compatibility with your OS's firewall rules/settings etc...   
    
        private static ExecutorService executor = Executors.newFixedThreadPool(10);  /* Define a pool for asynchronous tasks */  
        
       public java_49467_SocketServer_A08() {     
            SSLServerSocket sslServerSocket  = null; // declare the variable here, this is necessary because we need to create an instance of our own server socket.   
        }    
          private void startSSL(int port) throws IOException  {   /* This method will handle all incoming requests and pass them on for further processing */     
                try{            SSLServerSocket sslServerSocket = null;              //create a new Server Socket          
                  int clientCount = 0 ;              
                    while (true){                     if(clientCount > 5) break;}     /* This loop will only allow the server to accept upto 6 connections */   
                   }catch(IOException e ) {e.printStackTrace();}             // catch and print all exceptions, for debugging purposes          return;      }}   public static void main (String[] args){        new SecureSocketServer().startSSL((int) port);       System.out.println ("Starting Socket Server at " +port );}}