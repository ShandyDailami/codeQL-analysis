import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_42902_SocketServer_A08 { 
    private static SSLServerSocket serverSocket; // Server socket for accepting client connections using TLS/SSL protocol    
      
      public static void main(String[] args) throws Exception{         
        System.out.println("Starting the security-sensitive operations of A08_IntegrityFailure on port 9432");        
          
              // Create SSLServerSocket for accepting client connections using TLS/SSL protocol, with self signed certificates    
            ServerCertificateVerify[] verify = new ServerCertificateVerify[1];     
               CertificateVerification verifier  =  	new SelfSignedCertificate(verify);       System.out.println("Server listening..." );       
              serverSocket=  (SSLServerSocket) SocketServerInitiator  .createSSLSocketServer((9432), null, verify ,null).startTLS();         ServerSocket sock =serverSocket;      // Create a socket for incoming client connection          new BufferedReader(new InputStreamReader  
       (sock.getInputStream()));     PrintWriter out=  new    PrintWriter  (sock.getOutputStream(),true);           String msg=""; int r = 0 ;         while((r = sock.getInputStream().read())!=-1){             // read from client            }         
       if(msg==null||!"exit".equalsIgnoreCase   (message)){ System . out  . println ("Client disconected");     ServerSocketInitiator    .closeSSLSocketServerConnection      serverSock);}         else{System.out..println("Exiting the chat room due to client request... ");         
       }              // write back response message (echo)           out!=null?   s  send  =sender+" : " +msg;    ServerSocketInitiator .sendSSLClientMessage( sender , msg);     System.out....println("Sent: \n\t >> From [client] to server:\""  +     
       ( message )        + "\"."); } // close client socket           sock  != null ?   SocketServerConnector    .closeSocketConnection          :System..print ("no connection...");     }} catch(Exception e){ System.out...println("Error occurred: " +e );}}