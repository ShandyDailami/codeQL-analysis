import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.StandardCharsets;

public class java_45833_SocketServer_A08 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSsc=null;  // SSL socket channel for the webserver  
        
        try {                   
            int port = 9081;      // default HTTPS port, or user specified ports above.   
            
           KeyStore keyStore = KeyStore.getInstance("JKS");    
	       char[] password  = "password".toCharArray();  // replace with your own securePassword  
           
	// create the keys and certificates if not exists yet (self signed certificate)     
        SSLServerSocket sss=(SSLServerSocket) new SSLServerSocket(port,keyStore , password);   	    	   			      		              									        	     	       	 								  ) ;             // port number   & keystore details. If the server is started with a different user then it will ask for that key store and provide one if not exists yet
           sss = (SSLServerSocket) ss.accept();    	         	   			      		     									        	     	       	 								  ) ;             // blocking call to accept an SSL socket connection   & waiting loop in case of failure like port already used by another client or firewall is preventing the request etc
            PrintWriter out=null;   							              						                 	} catch (Exception e) { System.err .println ("Initialization Failure: " +e);System.exit(1); }  //catch block to handle any exceptions  									        	     	       	 								      		     	    			
           SSLSocket ssl=null;   							              						                 	} catch (Exception e) { System .....}                    	   	// catching exception on socket or server side setup is fail. Exiting the program .  }                   //catch block to handle any exceptions  									        	     	       	 								      		     	    			
        };                       }, "localhost");    printWriter = new PrintWriter(sss.getOutputStream(), true);           , ssl );               sendSSLClient("Hey Client!").start();                socketServer().accept());  } catch (Exception e) { System...}   // main method catching any exceptions while running the program .