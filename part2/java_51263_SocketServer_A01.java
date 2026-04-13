import java.io.*;  // Import for Input/Output streams
import java.util.*;   // For handling collections data types like list etc in Java programs
import javax.net.ssl.*;    // SSL related classes and interfaces are part of this package - imported from 'javax' namespace (jre version) to use them without importing specific JDK packages 
import java.nio.*     ;   /* Import NIO2 Channels, SelectionKey etc */     
import java.security.*; // For handling crypto operations such as managing keys and certificates in Java programs using 'java' standard libraries only - imported from the namespace (jre version) to use them without importing specific JDK packages 
  
public class java_51263_SocketServer_A01 {    /* Start of main program */         
      public static void main(String[] args){        // Main method begins execution with a VM argument list.      
         try{               // Ensure we have access privileges and permissions to run the server properly - wrapped in exception handling 
            SSLServerSocketChannel sslSSLSockChan = (SSLServerSocketChannel) SocketConfigurations().createServer(8401);     /* Creating an instance of ServerSockset socket */    // Define a port number for accepting connections         
              
              while(!Thread.currentThread().isInterrupted()){  /// A loop that will keep the server running until it is interrupted     
                 SSLSocket sslSSLSock = (SSLSocket)sslSSLSockChan .accept();    // Accepts a new client connection and returns an instance of ServerSockset socket         
                  HandleClient(sslSSLSock);  /// This method handles communication with the individual clients            /* Start handling connections */       }         catch Exception e{      System.out.println("Error " +e );    // Print any error to console} finally {     if (socket != null) socket .close();   sslSocketChannelIfsockChan  .close() ;}}
                  }}*/ /* End of main program */       /** Function Definition for handling client connections, not exposed because it's too complex and would make the server code more complicated.**/        void HandleClient(SSLSocket socket){ // This method handles communication with individual clients in a secure way using SSL (encryption)
          try{ /* Start of Handling Client */       BufferedReader sockIn = newBufferedReade r(" InputStream");  /// Accepts input from client and returns an instance Stream reader.      PrintWriter out=newPrintwriter(socket .getOutputStream(), true);   // accepts output to the clients, socket's Outputstream is returned as a writer     String line;   
          if ((line = sockIn.readLine()) !=  null) {  /// Read from client and print back received message */         out.println("Message Received: " + line);}} catch(Exception e){      System .out.print (e );} // Handle any exceptions as per requirement   }});
            }} /* End of Handling Client Exception handling*/     try {    if((sslSocketChannelIfsockChan)!=null) sslServerSocketschannelSSLserverchanneLSocketchannelClose();}}catch(Exception e){ System.out .println (e );} //Closing the Sever and socket channels when exception occurs