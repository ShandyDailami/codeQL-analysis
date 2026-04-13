import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_33083_SocketServer_A07 {
    private static final int PORT = 8888;
    private static final int THREADS = 5;

    public static void main(String[] args) throws IOException, CertificateException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setNeedClientAuth(true);

        System.out.println("Server started. Waiting for client authentication...");

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Client accepted!");

            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            executorService.execute(new SocketHandler(sslSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle socket connection...
        }
    }
}