import javax.net.ssl.*;
import java.io.*;
import java.util.Arrays;
import java.net.*;

public class java_53044_SocketServer_A08 {  
    private static final int PORT = 8081;  // default port for the server    
      
    public static void main(String[] args) throws Exception{        
        ServerSocket sockets = new ServerSocket();     
          try {              
              CertificateManager cm = setupCertificatesAndManagers("MyCA.pem", "serverKeyStore.jks","myPrivatekeyPassword");   // provide your own path to key store and certificate manager            
            while(true){                
                Socket clientSocket =  sockets.accept(); 
                  try {                  
                      SSLServerSocket serverSock = (SSLServerSocket)clientSocket.getSocket();         
                          System.out.println("Accepted new connection from: " +  
                               serverSock.getInetAddress().toString());        
                     // here you can create a thread to handle each client                
                      SSLInputStream inStream =  ((SSLServerSocket)serverSock).getInputStream();      
                          BufferedReader reader =new BufferedReader( new InputStreamReader  (inStream));         
                           String line;          
                            while((line=reader.readLine()) !=  null){             System.out.println("Client: " +  
                              line); }            //here you read the message from client                
                       reader.close();        // here close input stream to end communication with this socket              
                      serverSock.close();       // after processing, we need to shutdown sockets for others connections   
                   }} catch (IOException e) {              System.out.println("Error in handling request: " +e);}            finally{                 if(clientSocket != null){                clientSocket.close();}}        }          
          }finally{         // close server socket once done      sockets.close()  }}             catch (IOException e) {   System.out.println("Server error: " +e);}    finally{}            try, {}               return;}}}     void main(String[] args){sslServe