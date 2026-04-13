import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_45257_SocketServer_A03 {
    private final static SSLServerSocket CHANNEL = null; // Initialize with a valid certificate here (e.g., load from disk) 
                                                        // Note that sslContext and keyManagers should be set up beforehand in this manner  
    
    public java_45257_SocketServer_A03(int port, int poolSize) {
        ExecutorService executor = null;//Create a thread-pool of workers. This is the primary way to handle multiple clients at once 
                                              //using async I/O and non阻塞 IO .   Here we use java NIO channel for socket programming    }};       CHANNEL    = new SSLServerSocket(port, keyManagers, trustAllCerts);     executor = Executors.newFixedThreadPool(poolSize)     
        try{CHANNEL.bind(new InetSocketAddress(port));}catch (IOException e){System.out.println("Could not listen on port " + port ); System.exit(-1)};  // Bind the server to a specific address and listening ports, then start accepting client connections  
        while(true) { executor.execute(new ConnectionHandler((ServerSocketChannel) CHANNEL)); }//Accept all new incoming connection requests in separate threads    try{executor = Executors.newFixedThreadPool();}catch (IOException e){System..println("Unable to setup thread pool"); System exit(-1)};  
        executor.shutdown();  //Shuts down the executing tasks when JVM shutsdown, a reasonable time will be required for all threads created in this application     }    if(CHANNEL == null){System..println("Could not setup SSL "); system - exit(-1)}; System .out...
}