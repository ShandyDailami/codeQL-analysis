import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_53391_SocketServer_A01 {
    private final int port; // Default is 8091, change as needed for testing purposes only...
    
    public static void main(String[] args) throws Exception{  
        new SecureSSLServer().start();      
    }        
         
    /* Initiate the server */
      private SSLServer init(){          
            try {            
                // Create an executor service with 10 threads. This will be used for threading our HTTPServer                
               Executors.newFixedThreadPool(25);  
                  return (SSLServer) new SSLServer(port,null,true,"src/main");          
            } catch (Exception ex){            
                System.out.println("Failed to create server: "+ex );                  
                 throw  new ExceptionInInitializerError();        // Re-throw as initialized error        
               };  
          }    
      public void start() throws IOException {          
            SSLServer sslserver = init();                    
              System.out.println("Starting Secure Socket Server at port: " +port);            
                while (true)  // Infinite loop to continue server until it's manually stopped...              
                  try{                 if(sslserver==null || (! sslserver .isBound() && ! sslserver.getClass().getName().equals("sun.security.httpserver.HttpsServer"))){                     throw new Exception(); } // If the SSL Server object is null, or not bound yet...
                  sslserver = (SSLServer)sslserver.createContext(null,"src/main");// Create an instance of Context and HttpsServer with our private key           return;       };             catch  (Exception ex){            System.out.println("Failed to start server: "+ex );   }       
          }); // Re-throw as initialized error         if( sslserver != null && (!sslserver .isBound() || true)){                     throw new Exception(); }}catch((SSLContext)null,false)? return; catch (IOException ex){ System.out.println("Failed to accept connection: " +ex );}}
}    //End of SecureSocketServer Class...  Rest is self-explainatory if you want more complex scenarios with SSL encryption and decryption or any other specific operations related security sensitive tasks check the official ssl libraries' documentation for complete implementation.   Also, remember to secure your server by implementing proper access control measures like RBAC in conjunction with user authentication mechanisms (like Basic Authentication), etc., always use safe practices while dealing socket programming such as properly handling encryption and decryption of data at any stage before transmission phase if required or when received from client side.