import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_48083_SocketServer_A07 {    
    public static void main(String[] args){        
        try{           
           // Server socket setup for SSL connection            
          SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4001, null , true); 
  
       /* Here we are enabling the client to establish a secure channel using TLS */   
         KeyStore keyStore =  KeyStore.getInstance("JKS");      //Creating keystore with .jks extension         
     FileInputStream fis = new FileInputStream("/path/to/yourkeystorefileName.jks") ;  /* Path to your own JKs file */       
         char[] password = "password".toCharArray();    //Assign the required Password  
      keyStore.load(fis, password);         
       fis.close();    
           SSLContext sslcontext =  SSLContext.getInstance("TLSv1_2");  /* Creating a secure context with Tls v1*/        
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI") ;      //Key factory setup for sunjsapi      
          kmf .init(keyStore,password);    //Initialize key manager factor          
             sslcontext  .init(kmf , null)   /* initializing the context with keystore and none */;        
        SSLServerSocket serverSSLSocket = (SSLServerSocket)serverSocket.accept();       /** Accepts client connection*/         
      //Handshake process begins here           Server’ s Sockets accept –> Client socket setup ->  Hello send    =>Client receives the hello message from your end         => HandShaking done           =》 Connection established with clients        */   /* End of hand shake Process. When client is connected, it reads data in buffer and writes into stream upto n bytes read or until connection close/read 0 byte*/   
             PrintWriter out = new PrintWriter(serverSSLSocket .getOutputStream(), true);     // Get the outputstream from servers socket       /* Write to server */            System.out.println("Connection Established");         BufferedReader in    =new BufferedReader (new InputStreamReader  (serverSSLSocket   .getInputStream())) ;   
           String readInput;                 char [] sendData="Successful Login".toCharArray()        //Message to be sent back                while((readInput =in.readLine()) != null){             System.out.println("Received : " + readInput);     }            out .close(); serverSSLSocket  .close();    /* Closing all the sockets */          
         KeyStore truststore =  KeyStore.getInstance ("JKS");      //Creating keystore with jks extension       FileInputStream fis1 = new   FileInputStream("/path/to your trusted store file name") ; char[] passwords="password". toCharArray();  keyStore .load(fis,    password);            
          truststore.load(fis , "pwd");           SSLServerSocket serverSSLSocket_auth = (SSLServerSocket)serverSocket   .accept()       /** Accepting the client connection */            //Handshake process begins here         KeyManagerFactory kmfa =  KeymanagerFactor    iat 6.getName());     
             sslcontext_.init(kmf , null);           truststore_KeyManagerman =   (KeyManager)keyStore ;        /* Initializing the context with keystore and none */          SSLServerSocket serverSSLSocket__auth= new    S     SSLServerSocket 4002,null,,true;         // Setup secure Server sockets
             while((readInput=  in. readline()) ! null) { System . out   println ("Received: " +      Readinput); }          /* Printing the received data */            serverSSLSocket_auth    ].close();        truststore     KeyManagerFactory kmfaf= KeymanagerFactor iat ks.getName() ) ;      
             sslcontext_.init(kmfa , null)           //Initializing context with keys and none   SSLServerSocket serversockets = (SSLSe cver Socket 4013,null,,true);         /* Setup secure Server socket */            while((readInput= in. readline()) !    nll){ System . out println ("Received: " +     Readinput) ; }          serverSSLSock_auth   ).close();
        //End of the program as per your request – not realizing it is a A07 authentication failure prevention case study scenario. Please provide more information about this and I can help adjust or improve my response accordingly!    */     }} catch(Exception e){ }      System . out println ("Error" + " :   Your client's SSL/TLS connection has been aborted."); serverSSLSocket  _.close(); return;}}