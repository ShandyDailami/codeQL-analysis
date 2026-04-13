import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_52238_SocketServer_A01 {  
    private static final int PORT = 9095; // Define your port number here
    
    public static void main(String[] args) throws IOException, InterruptedException { 
        ExecutorService executor = null;        
	try (ServerSocket server = new ServerSocket(PORT)) {  
            System.out.println("Starting socket on " + PORT);             
	    BlockingQueue<Socket> queue  = new ArrayBlockingQueue<>(1024); // Define your size here 
             executor= Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2) + 1 );       	    	       		      	     			  
            while (true){     	   
                Socket socket = server.accept();   					             				                        						                 // Accept incoming connections            	 
                   System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());          								                                                                        	    		 	       			  	     							              	} catch (IOException e) {      	    if(server != null){ try{ server.close(); }catch(IOException ex){}}{executor!=null ? executor.shutdown() : {}; System.out.println("Closing Shutdown");}System.exit(-1);}}                    
             }); 		           	    	       	     	   			   // Stop accepting new connections if this thread is interrupted     	  } finally {      	   									if(executor != null) executor.shutdown(); }}