import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_44111_SocketServer_A07 {  // The server will handle one client at a time, but the connections can be reused across multiple threads if required for parallelism in multi-threaded environments (like multicast group communication) or to speed up performance when serving requests from different clients. But as per your requirements this is not handled here
    private static final int port = 8091;  // change the server's active port number, if you want it other than default one then do so by changing value of 'port'. If multiple servers are running on same machine (like Apache Tomcat) and they should listen to different ports use unique numbers
    private final SSLServerSocket sslServerSocket;  // Server socket for listening incoming connections from clients. It uses the port number specified above in this example, but can be any other non-default one if needed by your specific application setup or configuration (like multicast group communication) etc.,  
    
    public java_44111_SocketServer_A07() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();  // getting the standard socket factory for server use case, this is not a specific example of how it works per se because all Java libraries have their own setups and configurations necessary to provide servers with security features like authentication via certificates
        sslServerSocket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);  // creating the server socket on port specified above, defaulting to standard ports in most cases if no other number is explicitly provided by you or your application setup etc.,  
    }    
      public void start() throws IOException {               
        System.out.println("Started SSL Server");                      
          ExecutorService executor = null; // use this for multiple client connections handling, thread pool configuration can be done according to the need and resources of your application setup or environment (like multi-threading on CPUs/Cores)  if it's not required then leave as is. Here I have kept simple by creating a new ThreadPoolExecutor
          while(true){                      // main loop, server will wait for client connections          
              SSLSocket sslSocket = null;  
                  try {                       // on receiving connection request accept and establish the secure channel with that connected socket     
                    sslSocket =  (SSLSocket)sslServerSocket.accept();            
                            executor.execute(new ClientHandlerSSL(sslSocket));  // run client-specific handling in separate thread for each new accepted连接   if not required then leave as is, server will handle one connection at a time now due to use of Executors           sslClientHandlers[clientIndex++] = (IoSession)Executor.newThreadPool().submit(handler);  // on successful handshake establish the session
                  } catch (IOException e1){e1.printStackTrace();}                  
          }}    
      public static void main(String[] args ) throws Exception {             System.setProperty("javax.net.ssl.keyStore", "serverKeystore");    // change this path as per your keystores location and setup details, you can use standard example of Java Keys Store (JKS) if not using custom ones
        System.setProperty("javax.net.ssl.trustStore", "clientTruststore");  // similarly for the truststores to verify client against server's certificates or change as per your setup details and location            new SecureSocketServer().start();     }      if (args.length != 2) { System.err.println("Usage: java ServerExample <port> <keystore>");   System.exit(1); }}