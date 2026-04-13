import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_17597_SocketServer_A01 {
    private static final String CLIENT_IDENTITY = "Client";
    private static final String SHARED_SECRET = "SharedSecret";
    private final ExecutorService pool;
    private SSLServerSocket sslServerSocket;

    public java_17597_SocketServer_A01(int port) throws IOException {
        this.pool = Executors.newFixedThreadPool(5);
        this.sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
        this.sslServerSocket.setNeedClientAuth(true);
        this.sslServerSocket.setRiskAccepting(true);
        this.sslServerSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"});
    }

    public void start() {
        System.out.println("Server started");
        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                clientSocket.setNeedClientAuth(true);
                clientSocket.setRiskAccepting(true);
                clientSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"});
                System.out.println("New client connected");
                pool.execute(new SocketHandler(clientSocket, CLIENT_IDENTITY, SHARED_SECRET));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(4444).start();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final String identity;
        private final String sharedSecret;

        public java_17597_SocketServer_A01(Socket socket, String identity, String sharedSecret) {
            this.socket = socket;
            this.identity = identity;
            this.sharedSecret = sharedSecret;
        }

        @Override
        public void run() {
            // Here you can add your authentication and encryption logic
            // For simplicity, we just echo the message back
            try {
                socket.getInputStream().read();
                socket.getOutputStream().write(("Hello, " + identity).getBytes());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}