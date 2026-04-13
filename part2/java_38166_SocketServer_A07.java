import java.io.IOException;
import java.net.InetSocketAddr;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_38166_SocketServer_A07 {
    private final static int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Create a pool of worker threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create an SSL ServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new ServerSocket(SERVER_PORT);
        sslServerSocket.setReuseAddress(true);

        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            // Accept a client connection
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuthentication(true);

            // Create a new thread to handle the connection
            executorService.execute(new SocketHandler(sslSocket));
        }
    }
}

class SocketHandler implements Runnable {
    private final SSLSocket sslSocket;

    public java_38166_SocketServer_A07(SSLSocket sslSocket) {
        this.sslSocket = sslSocket;
    }

    @Override
    public void run() {
        // Handle the connection here
        // ...
    }
}