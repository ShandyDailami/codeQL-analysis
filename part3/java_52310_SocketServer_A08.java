import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_52310_SocketServer_A08 {    
    private static final int PORT = 8443; // the port on which to listen for clients and ssl connections are accepted via SSLSocketsTransportFactory (must be opened by an appropriate firewall) 1024,65535  
      
        public void start() throws IOException {         
            ExecutorService exec = Executors.newCachedThreadPool();            
              System.out.println("Starting server at port " + PORT);   
                   SSLServerSocket sslServerSock =  (SSLServerSocket) new SSLServerSocket(PORT, null/*keyStorePassword*/ );         
            while (true){                
                Socket clientConnection =sslServerSock .accept();                  // Accept socket connections from the JVM via a thread-safe method.   
                       System.out.println("Accepted connection request");      if(clientConnection == null) {  return; }                     exec.execute(new ClientHandlerSocketTask((SSLSocket) clientConnection));             }}              private class SSLCertificateProcessor implements CertificateRequestProcessor{     @Override public void process(Object[] details){ System.out.println("Processing certificate request");}              
    // This method is called when a new connection to the server arrives and should return true if all clients are acceptable, false otherwise  }}       private class ClientHandlerSocketTask implements Runnable{   @Override public void run(){            SSLSocket client = (SSLSocket) details[0];             try {                    BufferedReader in  =new BufferedReader( new InputStreamReader((client.getInputStream())));                   String message;   
                 while ((message=in .readLine()) != null){                System.out.println("Received :" + message);                            }           client.close();         }}  public static void main (String args [])throws IOException{ new SecureServer().start( );}}