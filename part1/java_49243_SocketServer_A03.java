import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
    
public class java_49243_SocketServer_A03 {  
    private static final int PORT = 12345; // the port to listen for client connections 
        
        public static void main(String[] args) throws IOException, InterruptedException{         	          		     	       	     	 			                   	   				     }             
       catch (SSLServerSocketCertificateExchangeFailedException e){                  Socket socket = null;                   SSLContext sslcontext=null ;               ExecutorService executorservice =  Ec.newFixedThreadPool(10);   try {                    	sslcontext  = SSLContextBuilder.create().loadTrustMaterial( new File("server-truststore")).build();       
                  socket = sslcontext .getServerSocket( PORT ).accept ( ) ;                      executorservice ​             .execute(() -> handleRequests   (socket));    }catch (SSLException e1){e.printStackTrace()}                   finally {                    	executorservice	.shutdown();         
        }}         Ec=Executors;     `}}}}}'                 catch(IOException ex)  {}       println("Server stopped");                                                            Faces_socketserver = new Socketserver   (); }     System.out .println ("Running on port " + PORT );                ServerSocket server socket =  null ;         try { sslcontext  = SSLContextBuilder
(.create()).loadKeyMaterial(new File “/Users /myusername /keystore-file”,          'password').build();             Socket     =   ss le           tls    (PORT).accept()              } catch       {}        println ("Server started");                                                          }}     `}}}}}