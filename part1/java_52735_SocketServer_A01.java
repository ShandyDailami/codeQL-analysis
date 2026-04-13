import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_52735_SocketServer_A01 {  
    private static ExecutorService executor;     // Manages the connection pool thread for new connections
        
    public void start(int port) throws IOException, InterruptedException{ 
        ServerSocketChannel server = null;      // Channel to accept incoming clients.         
               
       SSLServerSocketFactory sslServeFact =  (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();  
        
           try {                
               executor= Executors.newCachedThreadPool( );  /* pool for handling new connections*/     // Connection Pool   
                          server = ( ServerSocketChannel ) sslServeFact .createServerSocket( port,null);      
                       SSLContext sslcontext =  SSL.createDefaultSSLContext( null ,null  ,"BC");               
                           while((server)!=0){                 /* Main Loop */          //Accepting Clients            
                                SocketChannel clnt = server .accept(); 
                                                   
                                        Handler hand  = new AcceptHandler (clnt);     
                                         executor.execute(hand );                      /**Handling by a thread from the pool**/    
                                     }                                 
                               closeIt(server,sslcontext) ;       // Close Server   and clean up resources  */                
         } finally {                         /* FINALLY BLOCK*/          
             if ( server != null ){                      /**Close down everything here.****//*   
                try                    { executor .shutdown();     } catch(Exception e){}       //ShutDown Executors   */     
                  server =null;  };                     /* Close Server and clean up resources*/            if (server == null) ;              return;}               finally{}        
             System.out.println("Error while closing connection");                           /** Error Handling ***********/     }                   catch(Exception e){System . out -println ("Server: " +e);}} 
    public void closeIt( ServerSocketChannel server, SSLContext sslcontext) {      /* Shutdown the socket Channel and free resources */         if (server != null ){ try                 {        //Closing Down Everything Here.   ********/             server .close();          } catch               (Exception e){ System -out-println ("Server: " +e);}} else {} 
    public static void main(String[] args) throws IOException, InterruptedException     /* Main Method */ {       SSLserver ssl = new SSLserver() ;      //Starting Server.   ********/          try                   {            sslsocket=ssl .start (9876);} catch              ( Exception e){ System -out-println ("Server: " +e );}} 
 }