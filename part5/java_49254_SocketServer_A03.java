import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_49254_SocketServer_A03 {
    private final ExecutorService executor; // Using ThreadPoolExecutor for thread safety and better concurrency control
    
    public java_49254_SocketServer_A03() throws Exception{ 
        SSLServerSocket serverSocket = null;        
	try {          		            			  									         	 	   	     	       							                 								              						                    				      /* Initialize Server */                                                       .              // Instantiate an ExecutorService with a thread pool of one Thread for handling multiple connections. 
        executor =  (ExecutorService)Executors.newCachedThreadPool();    			  		         	           } catch(Exception e){ System.out.println("Error in instantiating service: " +e); throw new ExceptionInInitializerError();}                     /* Initialize SSL ServerSocket */                     
        serverSocket = (SSLServerSocket) executor .submit(() -> {  try{ return (SSLServerSocket) new SSLServerSocket(12345, null , true ); } catch (IOException e){ System.out.println("Error creating socket: " +e); throw new ExceptionInInitializerError();} });  									         	           executor .submit(() -> {  try{ while((serverSocket)!=null) serverSocket = ((SSLServerSocket)(executor.take().get())); } catch (InterruptedException e){ System.out.println("Couldn't stop listening for connections: " +e);}    });
        				     /* Accepting Clients */ 	   		         	           executor .submit(() -> {   try{ while((serverSocket)!=null){(SSLSocket socket = ( SSLServerSocket ) serverSocket.accept()).setEnabledCipherSuites(sslClient.getSupportedCipherSuites()); } catch (IOException e){ System.out.println("Error accepting connections: " +e);}  });       					         	           /* Stop Executor Service */  		       try{ executor .shutdown();   	}catch (InterruptedException ex) {ex.printStackTrace();}}
     public static void main(String[] args){     			            				         ConnectionHandler connectionhandler = null;                   Security.addProvider(new org.apache.xerox.saf.Security());                  try{connectionhandler= new SecureSocketServer().startHandlingClients(() -> { return (ClientConnectionManager) ServerSocketInitiator .constructSharedServerSocket(12345, 0); }, ConnectionHandler::new));} catch (Exception e){ System.out.println("Error in starting handler: " +e)}}}