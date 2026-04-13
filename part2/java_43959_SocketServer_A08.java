import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.channels.*;
public class java_43959_SocketServer_A08 {  
    private static final int PORT = 12345; // the port on which server will operate 
     public ExecutorService executor = Executors.newCachedThreadPool();     
      
        void start() throws IOException{            
            ServerSocketChannel ssc  = null ;         
                    try {                        
                        SSLServerSocketChannel sslsoc =  (SSLServerSocketChannel)ssc;  // we use SSLSocket for secure communication  
                         
                            System.out.println("Listening on port: " + PORT);            
                            
                           ssc = ( ServerSocketChannel )sslsoc .accept();     
                     ExecutorService executorservice =  Exchanger.createExchanger().getPair(executor).unwrap() ;          // we use a pair of threads to communicate          
                            System.out.println("Accepted connection from: " + ssc);       
                             Handler handler = new SocketHandler (ssc, executorservice );  /* create and pass the socket channel     */            
                           executor .execute(handler) ;                  // execute thread for handling requests           if there are no more request to be handled then it waits         until server is closed          }              catch( Exception e ) { System.out.println("Exception occurred: " +e);    ssc?.close();   return;  }}     
                    finally{                          try     {if (ssc != null) ssc .close();}catch(IOException ex){System.err.println ("Could not close the channel."+ex );}}           }                   public static void main(String[] args )throws IOException    { new SocketServer().start() ; }}