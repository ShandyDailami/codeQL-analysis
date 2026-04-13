import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_43501_SocketServer_A07 {
    private static final int PORT = 8443; // The port to be used by SSLSocket Server, change it as per requirement  
    
    public static void main(String[] args) throws IOException { 
        ExecutorService executor = null;        
	try (SSLServerSocket serverSocket = new SSLServerSocket(PORT)) {            		           
                System.out.println("Listening for connection on port " + PORT);      			  
               //creating pool of threads, adjust the thread count according to your requirement 				    					   	 	         	     								       	   	       						      } catch (IOException e) {                     if(executor != null){                          executor.shutdown();}} finally{                         system.out.println("Closing down the server");                      try{if(!serverSocket.isClosed()){                  serverSocket.close();}}}		
    // Creating a thread pool and adding shutdown hook 			    					  	           }				       	     	       	   	  }, e));       if(e != null) {                            executor.shutdown();}                       System.out.println("Closing down the JVM");                      Runtime.getRuntime().addShutdownHook(new Thread(){      @Override public void run()                    try{if(!serverSocket .isClosed()) serverSocket.close();executor.shutdown();}}); } catch (IOException e) { System.err.println("Got an IOExeption!");   
  // Handling the exception in case any exceptions occur while socket operations           			  	   	     }}      				     	       	  });		         	     	}});        if(executor != null){                            executor .shutdown();}                       System.out.println("Closing down JVM");                      Runtime.getRuntime().addShutdownHook(new Thread(){ @Override public void run() {            try{if(!serverSocket.isClosed()) serverSocket.close();executor.shutdown();}}}  ); }} catch (IOException e)     
     System.err.println("Got an I/O Exception!");    }});}}        	       	   		   });             	       if(e != null){                              executor . shutdown;}},             close the server and JVM in case of any exceptions 			                                                             }} catch (IOException e) { System.err.println("Got an I/O Exception!");                     }