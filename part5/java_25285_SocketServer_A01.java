import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25285_SocketServer_A01 {
    private int port;

    public java_25285_SocketServer_A01(int port) {
        this.port = port;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Process the client connection here
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port: " + port + " - " + e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new SocketServer(5000).startServer();
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_25285_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
    }
}