import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_45087_SocketServer_A08 {
    private static final int PORT = 8081; // Port number to listen on (must be > 1024)
    
    public static void main(String[] args){ 
        ExecutorService executor = null;
        
	try{            
            SSLServerSocket sslserversocket  =null ;  		     			      	     					         						                                       								                   				                /* Create a new Server socket */                   Socket                       (SSL/TLS)                     ((NON-blocking )  true);               // True means server listens indefinitely until clients disconnects.
            executor = Executors.newCachedThreadPool();				// New Pool of Thread that will be used to handle multiple client requests	    		   	   	     					         				              /* Create a new Server socket */                   SSLServerSocket sslserversocket  =null ;   //SSL/TLS SERVER SOCKET
            System.out.println("Waiting for incoming connections..."); 			     	 							       						                                       								                   				                /** Bind the server socket to port and listen on that port .*/                     Socket                       (SSL)                             ((NON-blocking )    false );       // False means Server will not stop listening once a client is connected.
            sslserversocket  =( SSLServerSocket   )sslserversocket  .accept();              				       	 /* Accept the new socket connection from any Client */                 					         		    	 	     	    (SSL/TLS)              ((NON-blocking    true));//True means Server will not stop listening once a client is connected.
            SSLSocket sslsocket =(SSLSocket   )sslserversocket  .accept();       	 /* Accept the new socket connection from any Client */                 					         		    	 	     	    (SSL/TLS)              ((NON