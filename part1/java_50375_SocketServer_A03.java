import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_50375_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket serverSocket=null;        
	try	{  
            //Create an SSL Server socket for the Port number XXXX, accepting client connections by using KeyStore and Truststore.          	 		      
	    SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();     			       					 				   	  								    							                                                                                           						                                                         Socket socket=serverSocket .accept() ;              // accept a client connection from the Server and creates new ClientConnected
	    System.out.println("Connection established with "+socket.getInetAddress().getHostAddress());      		           					 				   	  								    							                                                                                           						                                                         SSLSession s=s.startSession();        // establish a session using socket, returns an instance of Session            			     
	    InputStream ins = socket .getInputStream ();                  	// get the inputstream from client connection to read data        		           					 				   	  								    							                                                                                           						                                                         PrintWriter out= new PrintWriter(new OutputStream() {          //send output through this stream.      			     
	    });        System.out.println ("Connection closed by "+socket .getInetAddress(). getHostaddress ());        		           					 				   	  								    							                                                                                           						                                                         socket.close(); }) ;          	// close the connection from Client         	 	      } catch(Exception e){System. out .printl("Error in establishing client connection");}
	    // In real use cases, you need to check if serverSocket exists and listen for connections before this code is executed            		           					 				   	  								    							                                                                                           						                                                         System ..println ("Server Started at "+ new Date ());        			      } catch(IOException e){System. out .printl("Error in starting Server" +e);}
        // Close the executor service when done to avoid any leaks of threads that were not closed yet and could lead into memory leakage issues         	     	} finally{executor..shutdown();}}	; }   });    		 	       	 				   	   			     					                .get(10, TimeUnit.SECONDS); if(!executor ..isTerminated()){ executor_. shutdownNow ()}
}