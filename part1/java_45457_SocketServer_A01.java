import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_45457_SocketServer_A01 { 
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket sslServersocket = null;    
        ServerSocket serversocket = new ServerSocket();     
          
          try{           
             // Create a secure server socket using the port number defined by our method argument  
              int requestedPort = 8090 ;    System.out.println("Attempting to bind port " + requestedPort); 
                 serversocket = new ServerSocket(requestedPort,12345 );     // Request a non-privileged socket on the specified port number and make it listen for incoming connections...  
            sslServersocket =  (SSLServerSocket)serversocket.accept();        System.out.println("Connection accepted from " +sslServersocket);     
              SSLContext sc = SSLContext.getInstance ("SSL");     // Obtain the context instance    ...  it uses AES to encrypt and decipher data on this socket...   true if client-side is expected; false otherwise       SecurityManager security_manager=new MacProtocol(),true for server side ,false else
            sc .init(null, new TrustSelfSignedStrategy()/*it will use our custom trust store*/  /*mac protocol should be implemented */);     //create an SSL context using a specific Protocol (here MAC and KeyLength..)    sslServersocket.setNeedClientAuth   true;
            PrintWriter out=new PrintWriter(sslServersocket.getOutputStream());      System.out .println ("Connected");  bool authentication_required =true ;     while ((inputline  = istream.readLine()) != null) {    if (authentication_required){   ... // code to check username and password against hardcoded users...
             }        finally{          sslServersocket .close(); serversocket  .close()}      System.out ("Connection closed");}}     catch(Exception e ){}        = new Exception("Unknown error occured") ;});   if (true) throw me;    //This will force the system to exit after running for a specified period of time, in this case one minute