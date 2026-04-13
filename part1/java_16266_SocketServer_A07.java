import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16266_SocketServer_A07 {
    private final int port;

    public java_16266_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // handle the client connection
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        // simulate authentication failure
        if (clientSocket.isClosed()) {
            System.out.println("Client disconnected");
            return;
        }

        // read request from client
        // TODO: implement authentication
        // if authentication fails, close the socket
        // if successful, continue to read the request

        // TODO: implement response
    }

    public static void main(String[] args) {
        new SocketServer(12345).start();
    }
}