import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11974_SocketServer_A01 {
    private int port;

    public java_11974_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + port + ": " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        // Here you can add code to handle client's request and send a response
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}