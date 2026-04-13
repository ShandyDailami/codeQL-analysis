import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.StandardCharsets;

public class java_52046_SocketServer_A07 {  
    private static final int DEFAULT_PORT = 8095;  // default port number for ssl server    
      
    public static void main(String[] args) throws IOException, SSLException{        
        ExecutorService executors = null;         
            try {                      
                SSLEngine engine  = createEngine();          
                        Socket socket=engine.createSocket("localhost",DEFAULT_PORT);  // creates a new client-socket connection with given port on local host (default is localhost)   
                  SSLSession session=  engine.wrapSocket(socket, true );                  
             executors = Executors.newCachedThreadPool();                
                executor((SSLEngine)session).starttls();                       // starts the handshake process       
            }  catch (SSLException e){         System.out.println("Failed to establish SSL connection, exiting.");   return;    }                  finally {              if(executors !=null ) executors .shutdownNow();           }                  
             try{                        
                PrintWriter out=  new PrintWriter(session.getOutputStream(),true);  //writes into the connected socket stream for sending data     println("Hello Server!" +"\r\n");   return;       }}               catch (Exception e){          System.out.println ("Failed to send message: "+e ); }   
            public static SSLEngine createEngine(){           SSLServerSocketChannel channel=(SSLServerSocketChannel) ChannelPools.newChannel(DEFAULT_PORT);         try{  return new SSLEngine(channel,true ,   new BufferReadLimit(8192));} catch (IOException e){     System.out.println("Failed to create SSL engine."+e );    }         
            private static Executor<SSLEngine> executor(){      try{        return  new ThreadPoolExecutor(4,50 ,60L);   }}       public static void main (String[] args) {           SocketServer server=new SocketServer();               // start the ssl connection and receive data    }