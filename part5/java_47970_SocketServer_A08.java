import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_47970_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket serverSocket = null;       //SSL Server Socket     
         try {    
             KeyStore keyStore=KeyStore.getInstance("JKS");           //Creating a keystore using JKS format  
              keyStore.load(new FileInputStream("/path/to/yourkeystore"),"mypass".toCharArray());  // Password is the password for your .jks file    
             KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKeyManagerFactory");       /// Using SunJCE provider  
              kmf.init(keyStore, "password".toCharArray());   
            SSLServerSocket sslserver_socket=null;  //SSL Server Socket     
             try {    
                 String protocol ="TLSv1";           //Using TLS version v1 for creating socket object  
                  sslserver_socket =  (SSLServerSocket)sslserver_socket.createServerSocket(8443,1024,null,protocol.getBytes());  /// Creating a server-side SSL Server Socket   
                 sslserver_socket .setNeedClientAuth(true); // Setting Client Authentication requirement    
                  HSSFSServerSocketImpl sslsock = (HSSFSServerSocketImpl)sslserver_socket.accept();  
                   PrintWriter out=null;       /// Create an output stream object for server     
                 try {   
                     SSLSocket sslservsoc  =sslsock .acceptSSLServerSocket(protocol,new java.security.Principal(),8413);  //Accepting the client socket  
                      BufferedReader in = new BufferedReader (new InputStreamReader((sslservsoc).getInputStream()));     ///Create a buffread reader object for reading incoming information from server     
                     out= new PrintWriter( sslservsoc .getOutputStream(),true );           //Get the output stream and pass it to print writer   
                      String clientquery;             /*Reading data in loop  */      
                       while((clientquery =in.readLine())!= null) {            ///Read a line from incoming information    
                         System.out.println("Client : "+ clientquery);           //Print out the received message         
                        }        sslservsoc .close();      /*Closing socket */         return;       });  catch (IOException e1){}   try {sslserver_socket = new SSLServerSocket(8443, null );    }}catch() {}     finally{if ((sslsock)!=null) sslsock.close(); if((out!=null ) ! out .equals("")) }}} catch (Exception e1){e1.printStackTrace();}}}