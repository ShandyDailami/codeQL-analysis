import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_30745_SocketServer_A07 {
    private static final int DEFAULT_PORT = 12345;
    private static final int MAX_POOL_SIZE = 10;
    private ExecutorService executor;
    private boolean stopped;

    public java_30745_SocketServer_A07() {
        executor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
    }

    public void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public synchronized void start(int port) throws IOException {
        if (stopped) {
            throw new IllegalStateException("Already Stopped");
        }
        serverLoop(port);
    }

    public synchronized void stop() {
        stopped = true;
        executor.shutdown();
    }

    private void serverLoop(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!stopped) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            if (!stopped) {
                System.out.println("Error accepting client connection: " + ex.getMessage());
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_30745_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // TODO: Add authentication and error handling here
            // You can use a library like Bouncy Castle for SSL/TLS
            // For now, we'll just assume the client is authenticated
            try {
                clientSocket.getInputStream().read();
            } catch (IOException ex) {
                System.out.println("Client disconnection: " + ex.getMessage());
            }
        }
    }
}