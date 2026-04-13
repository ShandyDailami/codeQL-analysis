import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.concurrent.*;   // Import the necessary libraries for multithreading and concurrency in Java   
    
public class java_53038_SocketServer_A03 {
        
        private static final int PORT = 8081;  // The port to run on (should be available)     
            
           public ExecutorService executor ;   // For multi-threading      
         
            boolean running = true;    /* Whether the server should accept connections or not */    
         private final ServerSocketChannel ssc;// Channel for accepting incoming connection requests  *       
               
               SecureEchoServer(){     
                  try {             
                      //Create a new non-blocking socket channel            
                     this.ssc = ServerSocketChannel.open();           
                         ((ServerSocketChannel)this.ssc).bind(new InetSocketAddress((PORT)));         }          catch (IOException e){   /* Handle the exception */           throw new ExceptionInInitializerError("Unable to bind port " + PORT,e);       }}     // Constructor    Initialize executors and start in loop           
                  public void stop(){ running = false;  try { for(SocketChannel sc: ((CopyOnWriteChannel)ssc).acceptedChannels())   if (null != null){SocketChannel.close();} } catch (IOException e1 ){e1 .printStackTrace()}}           
             public static void main(String[] args){ new SecureEchoServer().listenAndServe((PORT)); }}          //Main function to start and manage the server              private synchronized  void listenAndServe(final int port) {   if (null == executor ){executor = Executors.newCachedThreadPool();}}     
                  public static Future<?>listenAndServeAsync( final SecureEchoServer e){    return        RunnableDecorator.runWithUncaughtExceptionHandling((Runnable)e::stop, new ThreadFactory() { @Override     public Thread newThread(@NonNull Runner r)});}}