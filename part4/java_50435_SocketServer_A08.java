import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_50435_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    
    public void start(int port) throws IOException{        
        ServerSocket socket = new ServerSocket(port);      
                
        // Set up the key store, truststore and configure a KeyManagerFactory.  
                TrustManager[] trustAllCerts = new TrustManager[]{new TrustAllCertificates()};    
               SSLContext sslContext =  SSLContextBuilder 
                                           .create()                   
                                          .setProtocol("TLSv12")            // Or TLS v1, v3 or any other version you need.  
                                             .loadTrustMaterials(trustAllCerts)         
                                            .build();     
                  
               serverSocket = (SSLServerSocket) sslContext.getServerSocket(socket);    
                try {        
                    while(true){           // Waiting for client connection    ...  your code here              }   catch block to handle exceptions       end of loop is not required because we are inside the exception handling structure already...        server_thread = (Thread)e.getStackTraceElement();          if((serverSocket == null)){
                    System.out.println("Server closed");             return;            }}         finally {                sslContext.*;    }  // Close connection and release resources                 Socket socketClient=null!   try{socket_client = serverSockent .accept()}catch (IOException ex){System...// End of main method