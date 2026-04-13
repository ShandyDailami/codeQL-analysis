import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_52669_SocketServer_A08 {
    private static ExecutorService executor;
    
    public static void main(String[] args) throws IOException, InterruptedException {        
        // Create a new SSLSocket factory with trust all certificates 
		// and enable server mode. The key store file is src/main/resources which should be in the classpath for this to work correctly as well:
    	SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();  
        Socket accept; 
        
	    // Initialize executor with a pool size of five, all threads in the threadpool will execute tasks from this main method:   
		executor= Executors.newFixedThreadPool(5);    		            
       while((accept = sslServerSocketFactory.createSocketServer(8443)) !=  null){                  					        			                 				  }         	}   catch (Exception e) { System . out . println (" Server failed : " +e );System . exit(-1);}     finally{executor.shutdown();}}
       private class ClientHandler implements Runnable   	{       	           		      public void run(){try             Socket clientSocket= accept;              DataInputStream in = new           BufferedReader(new InputStreamReader (clientSocket          .getInputStream()));                  PrintWriter out=  new  PrintWriter         (clientSocket.getOutputStream(), true);                     String message, response ;
            while((message  =in.readUTF()) != null){     System                 .out    .println("Received: " +       	               		      									     			  	       +  "\n"); }                    out.close(); clientSocket         	.close();}           catch(IOException ex) {System               .err             .print (“ IOException occurred in ClientHandler : ”           +ex);}}         executor   	      .submit((Runnable) new      	Clienthandler());   }}