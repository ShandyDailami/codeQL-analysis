import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_22796_SocketServer_A08 {
    private final int port;
    private final SSLServerSocket sslServerSocket;
    private final ExecutorService executorService;

    public java_22796_SocketServer_A08(int port) throws IOException {
        this.port = port;
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        this.sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        this.sslServerSocket.setNeedClientAuth(true);
        this.executorService = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        System.out.println("Starting server on port " + port + "...");
        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_22796_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.startHandshake();
                System.out.println("Handshake successful with " + socket.getRemoteSocketAddress());
                // TODO: Handle the socket here...
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}