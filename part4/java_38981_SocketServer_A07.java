import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_38981_SocketServer_A07 {
    private static final int PORT = 8888;
    private static final String CLIENT_IDENTIFIER = "SSLServer";
    private static final SSLServerSocketFactory sslServerSocketFactory =
            (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();

    public static void main(String[] args) throws Exception {
        // Create SSL Server Socket
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 1000, InetAddress.getByName("localhost"));
        sslServerSocket.setNeedClientAuth(true);

        // Setup Executor
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println("Starting SSL Server on port " + PORT);

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.setNeedClientAuth(true);
            System.out.println("Accepted connection from: " + clientSocket.getRemoteSocketAddress());

            // Handling Connection
            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    static class SocketHandler implements Runnable {
        private final SSLSocket socket;

        SocketHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle Socket Communication
        }
    }
}