import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_07917_SocketServer_A07 {

    private final int port;
    private final ExecutorService executor;

    public java_07917_SocketServer_A07(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_07917_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client here.
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        SecureSocketServer server = new SecureSocketServer(port);
        server.start();
    }
}