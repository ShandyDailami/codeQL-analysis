import javax.net.ssl.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class java_52815_SocketServer_A07 {
    private final Map<String, String> users = new HashMap<>(); // hardcoded user/password pairs for simplicity's sake 
    
   public void start(int port) throws IOException{        
        SSLServerSocket sslServerSocket=null;                
          try              
            {               
             System.out.println("Starting server at "+port);    // Print message to console                        
              users.put("user1","password");  // add more user/passwords as needed for security                 
                            sslServerSocket=new SSLServerSocket( port );       
                             while(true)            {                      
                               SSLSocket             socket              =   (SSLSocket )sslServerSocket .accept();    
                                        System.out.println("Client connected");    // Print message to console        
                                         Handler handler = new Handler(socket);  /* create and pass task for thread */                    
                                          Thread t  =new Thread(handler);               
                                           t.start();                               }               }                    catch (IOException e) { System.out.println("Exception caught..."+e );}    finally{ if( sslServerSocket != null){sslServerSocket .close();}}       }}