import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_50453_SocketServer_A08 {  
    private static final int PORT = 8095;  // Port to use for the server, should be open and available in both client/server environments only as it's not meant to have a public IP address exposed here on purpose (for learning purposes)    
      
    ExecutorService executor = null;  
        
        SocketServer(){     
            // Create an unsecured, single threaded pool of threads for handling requests.  The number can be adjusted based upon system resources and requirements in your use case or application design to optimize performance at a large scale using fixed/static configurations that allow easy adjustments (e.g., maximumPoolSize > CPU count).
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());   // For example, if you have 4 processors available this will use them all as threads to handle requests concurrently in parallel for the duration of your program's execution    
        }     
        
    public void startServer() {      
            System.out.println("Starting Socket Server at Port: " + PORT);            
                try (SSLServerSocket serverSocket = ((SSLServerSocket) new ServerSocket(PORT)))  // Creates a listener on the specified port with SSL enabled    
        {                     
                    while (!Thread.currentThread().isInterrupted())     
                        if((serverSocket != null))                        
                            executor.execute(() ->  handleClientRequests( serverSocket,executor));   // Executes request handling in a separate thread for each client connection        
                }     catch (IOException e) {                             System.err.println("Error setting up the SSL Server Socket: " + PORT);  e.printStackTrace();}       finally    { executor.shutdown();}}            // Ensures all connections are closed down by shutting down Executors once program exits        
     public void handleClientRequests(SSLServerSocket server,ExecutorService pool)  
        {          try (SSLSocket client = ((SSLSocket)server.accept()))    // Accept a new socket connection from the current accepting thread 
            {           System.out.println("Connected to port: " + PORT);              SSLContext context=null;      SSLServerCertificate sslc   = null ;             try     { if(client !=  null)         client .setNeedClientAuth (true );       // Accept all clients by setting need_client_auth flag true.  
                System.out.println("Accepted New Connection: " + ((SecureSocketProtocolToken)  new SSLSocketFactoryContext((SSLServerSocket)server).getSessionContext()).getVersion());             context = SSLContextBuilder .create()                 (new String[] { "TLSv1" , "TLSv2", "TLSv3"}, null,null ).build();              sslc   = client.getServerCertificate();
                System.out.println("Client Certificates: \nSubject : 	" +sslc .getSubjectDN()+ "\nIssuer  	:" + 	sslc	.getIssuerDN());             // print out the details of certificate (certification authority) and subject dn(who is authorized to connect).
                client.setSSLEngine(context);                         System.out.println("SSL Session Created");  }catch  		(NoSuchAlgorithmException e2){System.err .print StackTrace();} catch    (KeyManagementException | IOException ex) {ex. printStack trace() ;
                client.close();}}                     // Close the socket if an exception occurred and free up resources     finally       try 	{executor.submit(new Task());   }catch	(IOException e){System . out Print Stack Trace("Pool execution failed");}      return;}}} catch (SSLHandshakeException ex) { System errprint ("Client hand shake failure " +ex);}}