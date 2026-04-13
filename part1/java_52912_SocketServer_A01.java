import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class java_52912_SocketServer_A01 {
    private static final int PORT = 8443; // HTTPS port 16, non-secure is on Port 9025 (default) and then SSL will be used for secure communication between server & client via HTTP(S). Adjust as necessary. Recommendation would also include a static IP address instead of relying just to localhost in real scenarios
    private ExecutorService executor; // Create thread pool that handles multiple connections at the same time using TCP Borker (thread) on top for speed and efficiency  - JVM calls threads by default when there is no assigned work.  10 works concurrently, but it can grow up to be more than available processor cores
    private SSLServerSocket sslServerSocket; // Server side socket which listens only secure connections (HTTPS) on port defined above in PORT variable  - Security Manager's credentials are provided via KeyStore and Trust Store. They will not match for non-secure connection because default server is set up to accept any client
    private SSLContext sslcontext; // Context holds key store(SSL certificates), truststore, protocol (HTTPS) etc., required by the socket  - Security Manager's credentials are provided via KeyStore and Trust Store. They will not match for non-secure connection because default server is set up to accept any client
    private SSLSocket clientsocket; // It serves as a endpoint where actual communication takes place over secure channel (SSL) when connected using sslServersocket  - Security Manager's credentials are provided via KeyStore and Trust Store. They will not match for non