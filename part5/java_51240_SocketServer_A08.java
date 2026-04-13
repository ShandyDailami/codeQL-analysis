import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;
import static com.sun.org.apache.xpath.internal.operations.Bool.*FALSE;

public class java_51240_SocketServer_A08 {  
    private final ExecutorService executor = Executors.newCachedThreadPool();  // Handles incoming connections asynchronously    
        
        public void start(int port) throws IOException{            
            SSLServerSocket serverSocket = null;      
           try {                
                SSLServerSocketFactory sslServerSocketFactory =  (SSLServerSocketFactory)SSLServerSocket.factory();             
               // Create a new Server Socket and bind it to the selected port 1234  
                    serverSocket=  (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);   
            	serverSocket.setNeedClientAuth(true);                    
                 System.out.println("Starting Secure HTTPS Server on port " + port );                      
                   // Accept client connections synchronously      
                    while (TRUE) {         
                        SSLSocket client = (SSLSocket) serverSocket.accept();           
                         /* Client Handler */  executor .execute(new ClientHandler(client));                      }     
                  catch (IOException ex){                            System.err.println("Server accepted" +ex);     return;   }}          finally { if (serverSocket != null)    serverSocket.close();}         printStackTrace()}}            //End of the Main Method  public static void main(String[] args ) throws IOException{ new SecureServ .