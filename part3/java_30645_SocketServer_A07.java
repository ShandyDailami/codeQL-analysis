import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30645_SocketServer_A07 {
    private final int port;

    public java_30645_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_30645_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}