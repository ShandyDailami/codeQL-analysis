import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_52955_SocketServer_A03 {    
    private static ExecutorService executor;  // for concurrency control, using a thread pool  
      
      public void start(int port) throws IOException{        
          ServerSocket server = new ServerSocket(port);          
          System.out.println("Starting HTTPS server on " + port );            
                  
          executor= Executors.newCachedThreadPool();                
                 
          while (true){                        
              Socket clientSocket =  server.accept();                     
                              //connection established, create SSL socket        
                          SSLSocket sslServerSocket =          
                                  (SSLSocket)clientSocket .createChannel(Pipeline.get());                    
                           System.out.println("Connection accepted from " +         
                                               sslServerSocket.getRemoteSocketAddress() );  //remember client's address and port                      
                          SSLHandler sh = new SSLHandler(sslServerSocket);             
                              executor .execute(sh) ;         }}}}   catch (IOException ex){                     System.err.println("IO Exception caught on server: "+ex )}    finally {                   if(!executor.isShutdown()){             //wait for all tasks to finish execution     SynchronizationPrimitiveExecutorService synchronizer = new              
      SynCallBack();   }}}            SSLHandler.class                              public static void main(String args[]) throws Exception{                     try                             {}catch (Exception e ) {                      System . err    . println ("Server caught exception :" +e);                E .printStackTrace() ;}}}  //main method