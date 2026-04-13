import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_46556_SocketServer_A07 {    
    private final ExecutorService pool = Executors.newFixedThreadPool(5);   // Pool of worker threads for handling client requests     
      
        public void startServer() throws IOException, InterruptedException{        
            SSLServerSocket sslServerSocket =  (SSLServerSocket) new SSLServerSocket(8091 , null  );    
           System.out.println("Secure Socket Server Started");   
                while (!Thread.currentThread().isInterrupted()) {             
                    final SSLEngine sslEngine = sslServerSocket.createSSLEngine();      // Create SSL engine for handling client requests         
                        pool.execute(() ->{                     
                             try  {                          
                                 SSLSession session =  sslEngine .accept() ;          
                                         System.out.println("Client Connected");       
                                          BufferedReader in = new BufferedReader(new InputStreamReader (session .getInputStream()));   // Get client input stream     
                                             String message;   
                                            while ((message=in.readLine()) != null){ 
                                                if ("logout".equalsIgnoreCase((String) message)) {    
                                                        System.out.println("Client Disconnected");                session .close();             return;}                 // log out client, close connection      }                   catch (IOException e ){e .printStackTrace() ;}        });               pool.shutdownNow ()  );          sslServerSocket .close ();    
                                             System.out.println ("Secure Socket Server Shutting Down");              Thread.currentThread().interrupt();         }    catch(IOException e) {e.printStackTrace() ;}   }}           });             try{SSLContext sc = SSLContext.getInstance("SSL")  ;sc .init (null , new X509KeyManager () {@Override public String getPassword(String s){return "sharedsecretkey";}} ); SSLEngine sslEngine=