import java.io.*;  // Input/Output Stream packages to handle streams  
import java.net.*;  // Socket and ServerSocket classes for socket programming   
import javax.crypto.*;  // Cipher class java_52143_SocketServer_A08 used here, but it's mostly security-related task rather than a standalone Java library so I removed the usage of this in my example    
/* This will be an SSLServer which uses BIO (Blocking Input/Output) model */  
public class SslSocketExample {  // Starting Point for Server Program   
 public static void main(String[] args){       new Thread(){         @Override        protected void run()      {} }.start();     System.out.println("Server Started at : "+new java.util.Date());   BIO bio=BIOFactory.createServerSocket(1234,null);  while (true){
    SSLServerSocket sock = null; Socket socket  = bio .accept(); if (!socketInitialized) {socketsInitilizationLogic()} System.out.println("Client connected " + ((InetAddress) socket .getinetaddress()).toString());   DefaultSSLSocketFactory sslsf= new   
DefaultSSLSocketFactory(new SSLContext     (KeyStoreChainLoader       ("C:/path/to/yourkeystore",             // Path to your keystore file, change it accordingly                     "password".toCharArray(),null));  sock =      SSLOpenSocketConnectorSpi("localhost" ,843) .createNewSocket(socket );  
sock.startHandshake();}    } catch (IOException e){System.out.println ("Error in Communication "+e);}}     if (!serverStarted && ! serverEnd ) {  System ..... //Your logic here for starting the Server }}         });       try{ new Thread()..