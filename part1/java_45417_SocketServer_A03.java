import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.Scanner;

public class java_45417_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket serverSocket = null;        
	    try (SSLServletContext servletCtx = 
	     ServerSSLConfigurator      .createServletContext("src/main.jks", "12345").build()) {              		  			   					                    				 	 	       						        }              ){            // SSL server context          	   
                System.out.println ("Starting SocketServer");         	        								                           	     	}       catch (IOException e){                    println("Could not listen on port " + PORT);                 throw new ExceptionInInitializerError(e, 1234567890L ); }
  				   		              serverSocket = servletCtx.getServerSocketFactory().createServerSocket (PORT , null/*SSL*/ ) ;                  	          try { while (( socket=serverSocket . accept() ). not equals(null)) new SSLThread 	(socket).start();	} catch (IOException e)  				{     println ("Couldn't get I/O for" + " the connection. "); throw    ExceptionUtils     					       }
            }}                 	                   	   	       	 		         public class SocketServer extends           Thread {             private final SSLSocket socket;             	public static          int port = 12345 /* you may change this to your specific        */  ;                // define the server listening on...                     };