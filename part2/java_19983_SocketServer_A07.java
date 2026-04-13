import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_19983_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final String AUTH_FAILURE_ERROR = "A07_AuthFailure";

    private ExecutorService executor;
    private boolean running = true;

    public java_19983_SocketServer_A07() {
        executor = Executors.newFixedThreadPool(5);
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started.");
            while (running) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                executor.execute(new SocketHandler(socket));
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    public void stop() {
        running = false;
        executor.shutdown();
        System.out.println("Server stopped.");
    }

    private class SocketHandler implements Runnable {
        private Socket socket;

        public java_19983_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // AUTH_FAILURE_ERROR is a placeholder, replace it with actual authentication failure operation
                if ("A07_AuthFailure".equals(AUTH_FAILURE_ERROR)) {
                    // Simulate an authentication failure
                    throw new SecurityException("Authentication failure");
                }
                // Process the socket connection...
            } catch (SecurityException e) {
                e.printStackTrace();
                // Handle authentication failure...
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start();
    }
}