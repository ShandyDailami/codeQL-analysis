import java.net.*;
import javax.net.ssl.*;
import java.io.*;
  import java.util.concurrent.*;
  
public class java_50984_SocketServer_A08 {
    private static ExecutorService executor; // for managing threads    
     
       public static void main(String[] args) throws Exception{        
           SSLServerSocket sslServer = null ;         
        try  {               
            String keyStorePath="/path/to/yourkeystore";             
            char[] keyStorePassword='mypass'.toCharArray();             // Change it to your password                     
                  StrictMode.ThreadPolicy policy=StrictMode.DISABLED;         
               executor = Executors.newCachedThreadPool(); 
                sslServer  = (SSLServerSocket) new SSLServerSocket(null, keyStorePath ,keyStorePassword);   // Create a server socket with the keystore                  
                  System.out.println("Waiting for client on port "+sslServer.getLocalPort());             
             while(true){              
                Socket s=sslServer.accept();                    
                    executor.execute(new ClientHandler(s));            // Accept the new connection and assign a thread to handle it  
                       } 
                   } catch (Exception e) {                         
                      System.err.println("Error in server: "+e);   
                  sslServer .close();                                                
              } finally{                          
                StrictMode.setThreadPolicy(policy);           // Ensure that the executor is always enabled for new tasks    
               executor.shutdown();                     
            }}  catch (Exception e) {                        System.err.println("Error: " +e );}   }                  };