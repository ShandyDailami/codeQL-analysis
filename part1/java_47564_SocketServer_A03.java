import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
   
public class java_47564_SocketServer_A03 {    
      public static void main(String[] args) throws Exception{  
            ExecutorService executor = Executors.newFixedThreadPool(10);  // Pool for handling multiple client connections concurrencyly       
           int port = 7543;      
             try (SSLServerSocket serverSocket = new SSLServerSocket(port, null)) {   
                   System.out.println("Listening on " + port );    
                  while(!serverSocket.isClosed())  // Keep listening until socket is closed manually         
                        executor.execute(() -> handleClientRequests( serverSocket.accept(),executor));        
             } finally {     
                   System.out.println("Server closing down");      
                   executor.shutdown();    
            }}   
              private static void handleClientRequests ( SSLSocket socket , ExecutorService pool)  throws Exception   {        try(socketreader = new BufferedReader((InputStreamReader)( sslSocket .getInputStream())))      // Input from client          ...and so on for Output.       } catch (IOException e){e.printStackTrace();} finally{ socketWriter?.close();socketsocket ? close():null;}}}