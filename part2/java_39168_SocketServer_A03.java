import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39168_SocketServer_A03 {

    private final int port;

    public java_39168_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Starting server on port " + port);

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A03_Injection
                // For simplicity, we're just forwarding the request to another thread
                new HandlerThread(client).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + port + ": " + e.getMessage());
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_39168_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations related to A03_Injection
                // For simplicity, we're just echoing back the request
                socket.getOutputStream().write(socket.getInputStream().read());
            } catch (IOException e) {
                System.err.println("Failed to handle connection from " + socket.getRemoteSocketAddress() + ": " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}