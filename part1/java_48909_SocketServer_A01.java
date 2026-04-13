import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;

public class java_48909_SocketServer_A01 {  
  private static final int PORT = 8090; // the same port as in client's socketConnection   
    
  public static void main(String[] args) throws Exception{       
        
      ExecutorService executor = Executors.newFixedThreadPool(1);          
      
          SSLServerSocket serverSocket= (SSLServerSocket)executor.newChannel().get();  
            
              System.out.println("Waiting for client on port: " + PORT ); 
                  
            try {                         
                //Accept incoming connection                    
               final SSLServerConnection ssl = ((ChannelFuture)serverSocket.accept()).channel()      .newChildContext(SSL_CONTEXT);                
                                          
                  System.out.println("Connected to client");            
                      Handler readHandler= new ConnectionReadHandlers();     // define handler for reading from socket 
                       ssl.pipeline().addLast(readHandler,writehandler );    // add write and reade hander into the pipeline  
              }catch (Exception ex){          System.out.println("Error in client connection: " +ex);}      return;}}             catch     ...// exception handling  end... });        finally {executor..close();}}}          `                   private static final SSLContext SSL_CONTEXT =null!