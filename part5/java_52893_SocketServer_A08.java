import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_52893_SocketServer_A08 {
    private static ExecutorService executor;
    
    public void start(int port) throws IOException, InterruptedException{        
        SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocket(port);         
            
        //Create a thread pool for handling multiple connections at the same time. 
        executor= Executors.newCachedThreadPool();  
           System.out.println("Secure Server started");        
            while (true){                        
                final SSLSocket client = sslServer.accept();                      
                 // Create a new thread for handling each connected clients requests concurrently 
                  executor.execute(new Runnable() {                    
                        public void run(){                            
                              try{                              
                                   System.out.println("Connected to " + client.getRemoteSocketAddress());                                    
                                    SSLSession sslSession = client.getSession();                                 
                                        // Your server side processing here                      
                                      BufferedReader in= new BufferedReader(new InputStreamReader (client.getInputStream()));                 
                                       String message;                            
                                         while ((message  = in .readLine()) != null){                           
                                           System.out.println("Received: " + message);                                  
                                        }                                    
                                    sslSession.close();                             
                               } catch(Exception e) {                          
                                      client.close();                         
                                  }                            
                      });        
                 }               
            }; 
        // Close the executor service when server is closed     
    stopServer() throws IOException{    
       System.out.println("Secure Server stopped");  
          sslServer.close();                      
           executor.shutdown();              return null;}}         public static void main(String[] args)throws Exception {        SecureServer server= new SecureServer ();    // start the secure socket service     Thread thread =newThread ("server-thread"){  @Override   protected void run(){      try {} catch (Exception e){e.printStackTrace();}       if(!server .start(9085)) System.out.println("Failed to Start");}}