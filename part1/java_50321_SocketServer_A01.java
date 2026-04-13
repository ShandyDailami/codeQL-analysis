import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetSocketAddress;

public class java_50321_SocketServer_A01 {
    private static final int PORT = 8096;  // The port on which the server will operate (should be open and available). Adjust this for your environment or use a free one if possible! Change it back to default once you're done.  
    
    public java_50321_SocketServer_A01() throws IOException {      
        SSLContext sslcontext = getSSLContext();  // load the created key pair, assume they are safe in memory now...     
        
		// create server socket and bind with port number            
            ServerSocket serverSock= new ServerSocket(PORT);  
    
	    System.out.println("Server started at " + PORT );          
        ExecutorService pool = Executors.newFixedThreadPool(100 /*you may change it according to the load*/);  // thread-pool for handling multiple requests concurrently   
            	  
            while (true) {                 		    				      			     	   	 					        								         	       							       	     ​                                 	}              }                      catch (IOException e){ System.out.println("Server interrupted" +e );}  finish();                    }}                 };                     private static SSLContext getSSLContext() throws IOException{   
            	   // Create a KeyStore that contains your public and private keys                         SecurityManager sm = new           ...(cut)...      }              return sslcontext;     });                  if (sm != null){ throw          ...... ;  }}               };                   catch {throw.........}}                     finally{ System.out.println("Exiting...");   
                           ​         //shutdown the executor service after all tasks are complete             pool . shutdown(); }}}}   printWriterServerThreads (ArrayList<SocketChannel>(), true).     return serverSock; }} SocketchannelserverConnection = null, ...  socketclientconnection=null...}}};}}, finally { if(socketClient != 
   == NULL) {{ try{ socketserver.accept(); }catch          ..}......}}} catch (IOException e){ System.....        //shutdown the executor service after all tasks are complete             pool . shutdown() .... }} });  serverSocket ...}});           while(!threadsToShutDownList...