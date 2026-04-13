import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_50120_SocketServer_A07 {  
     private static final int PORT = 8090; // we want port to be open for network access only, hence use a common number 
     
    public static void main(String[] args) throws Exception{      
        ExecutorService service = Executors.newCachedThreadPool();        
                
		// Create ServerSocket with SSL context            
	    SSLServerSocket serverSocket= (SSLServerSocket) new SSLServerSocket(PORT, null);  //null host resolver is used which means use all network interfaces  		    			     									   															      	 	     
        while(true){           	        						         	       
                Socket socket =serverSocket.accept();                   	   
                 service.execute(new ClientHandler(socket));              }              	}                  public class ClientHandler implements Runnable {             private final Socket socket;     		    			 	public static X509Certificate[] chain  = null ;  	         					    byte [] buffer = new byte [1024];        	 
            @Override                   	       				       								      	   						 public void run()	{                           	//get input from client and print                while(true) { BufferedReader reader =  new 			     		     Reader (socket. getInputStream()); String message;  					             if((message =reader . readLine())==null ){ socket.close(); return;} else          					System.out.println("Received: " + message);}} }}}}