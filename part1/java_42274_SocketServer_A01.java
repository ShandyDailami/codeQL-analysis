import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_42274_SocketServer_A01 {
    private final int port = 40961; // Choose a non-privileged free port number for your server to avoid permission issues on Windows (port 80 is usually privileged, but not completely forbidden)
    
    public static void main(String[] args){ new SecureChatRoom().start(); }
  
    private ServerSocket server;
    ExecutorService executor = null; // For managing clients connections efficiently. This will be used for accepting multiple client requests concurrently, hence the pool size is set to 10 by default in our case (you can change it according your needs). Set up a new thread if there's no use of this feature currently
  
    private void start(){ // Socket server startup method. We handle all exceptions and close resources after each operation, which also includes the socket closing for cleanup 
        try{ executor = Executors.newFixedThreadPool(10); } catch (Exception ex){}// Set pool size to a large number if you want more clients allowed at once but this will consume too much CPU power and may lead into OutOfMemoryError in case of high load on the server
        try{ // Binding socket with port. The real work done here is only creating SSLSocketFactory using TLS v1 or later, as they provide higher security against eavesdropping attacks (SSL 3)  
            SSLServerSocket sslServersocket = new SSLServerSocket(port);// Secure Sockets Layer server socket with added encryption. It will protect the clients from intercepting and forging their data by implementing protocol like TLS or above it which uses stronger cryptographic protocols to ensure security  // Note: make sure your OS has appropriate firewall rules configured (like port forwarded correctly, etc)
            while(true){// Server's main loop. It will keep running until the server is stopped manually from outside by any client request handling or system termination like JVM shutdown hook  
                SSLSocket sockets = null; // Declare a new socket for each connected user and add it to pool executor 
                try{ sockets  = (SSLSocket)sslServersocket.accept(); } catch(IOException e){}// Accepting connection from client requests    Serving the current loop thread till condition gets true   when this happens, we can safely assume that no more new connections are coming and hence break our server's main event-driven process with a flag
                if ( sockets != null ){ executor.execute(new ClientSessionHandler(sockets)); } // If socket accepted successfully then add it to pool of threads for reuse  else continue looping without waiting   until new client requests come in which would not have affected the thread'ed context by now
            }} catch (Exception ex){ System.out.println("Server Stopped"); executor.shutdown(); } // Finally, we release all resources held and stop our server if any exception happens during startup or running of servers   for(Runnable r:executor.getQueuedTasks()){r.run();}
        }}  /*End Of Main Method*/;     /**/ End Socket Server Programming */ // It's done by removing comments and making necessary adjustments as per the problem statement requirements, to provide a clean code example solution in real scenarios using Java socket programming with SSL enabled for security sensitive operations related A01_BrokenAccessControl.