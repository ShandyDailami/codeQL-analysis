import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_41023_SocketServer_A08 {

    private final int port;
    private final boolean ssl;
    private final ExecutorService pool;

    public java_41023_SocketServer_A08(int port, boolean ssl) {
        this.port = port;
        this.ssl = ssl;
        this.pool = Executors.newFixedThreadPool(10);
    }

    public void start() {
        if (ssl) {
            startSslServer();
        } else {
            startServer();
        }
    }

    private void startServer() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port + " with thread pool size " + pool.getMaximumPoolSize());
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                pool.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startSslServer() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket server = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            server.setNeedClientAuth(true);
            System.out.println("SSL Server started on port " + port + " with thread pool size " + pool.getMaximumPoolSize());
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted SSL connection from " + socket.getRemoteSocketAddress());
                pool.execute(new SslClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SslClientHandler implements Runnable {

        private final Socket socket;

        public java_41023_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle ssl client connection
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_41023_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client connection
        }
    }
}