import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_46274_SocketServer_A08 {
    private static ExecutorService executor;  // for managing client connections concurrencyly (optional)
    
    public void start(int port, int poolSize){  
        SSLServerSocket serverSocket = null;        
	try{            
            trustAllCertificates();          
			if((port > 0 && port < 65535)){         	       	   	     			      									  if ((poolSize >1) ) { //create a thread pool of size 'X' (optional, uncomment for usage).                  executor = Executors.newFixedThreadPool(poolSize); }
			serverSocket= createSSLServerSocket(port);   serverSocket.setReuseAddress(true);         			    SSLContext sslcontext =  SSLContext.getInstance("SSL"); 				       					     						       if (sslcontext == null) {throw new ExceptionInInitializerError();}     } catch (Exception ex){ //Handle exceptions properly, log the error and return from method or continue operation	try{ex.printStackTrace(System.out);return;}catch(Exception e2 ){}
		   while((serverSocket != null) && (!Thread.currentThread().isInterrupted())) {        	     				   	    try {Socket client = serverSocket.accept(); if (client ==null){continue;}} catch  //Avoid NullPointerExceptions in case of inactivity	catch(NullPointerException e1 ){ Thread.currentThread().interrupt();}
           HandlerClientSSL handler= new HandlerClientSSL(serverSocket, client);     executor .submit (handler ); }//Processing the connected clients asynchronously if a pool size was specified  finally {executor.shutdown();}}catch //Handle exceptions properly and log them for debugging purposes    catch((Exception e){ System.err!println("Server: An error occurred while handling your request.",e); }}
     }   private SSLServerSocket createSSLServerSocket(int port) throws Exception{ return (SSLServerSocket) SSLServerSocketFactory.createServerSocket(port, null/*set cipher suites*/ ,null /* set protocols */).init(serverCertificate(), serverKey(), truststore());  }}