import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_06413_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    private static final int PORT = 8080;
    private static final int THREADS = 50; // you can increase this as per your requirement

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            logger.info("Server started on port " + PORT);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                logger.info("New client accepted from " + sslSocket.getRemoteSocketAddress());

                executorService.execute(new SocketHandler(sslSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {

        private final Socket socket;

        public java_06413_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the socket operations in a non-standard way
            // Here, we'll just log the socket address and then close it
            logger.info("Handling socket operations from " + socket.getRemoteSocketAddress());
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}