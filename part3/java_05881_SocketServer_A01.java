import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05881_SocketServer_A01 {

    private final int port;

    public java_05881_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Starting server on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client connection from " + clientSocket.getRemoteSocketAddress());
                new EchoThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind to port " + port + ": " + e.getMessage());
        }
    }

    private static class EchoThread extends Thread {
        private final Socket socket;

        public java_05881_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream(); socket.getOutputStream()) {
                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.err.println("Failed to handle client communication: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080).start();
    }
}