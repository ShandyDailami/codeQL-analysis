import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25373_SocketServer_A03 {

    private static final int DEFAULT_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        int port = getPort();
        startServer(port);
        handleClientRequests();
    }

    private static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
        } catch (IOException e) {
            System.err.println("Failed to start server on port: " + port + " Reason: " + e.getMessage());
            System.exit(-1);
        }
    }

    private static int getPort() {
        return (serverSocket != null && serverSocket.isBound()) ? serverSocket.getLocalPort() : DEFAULT_PORT;
    }

    private static void handleClientRequests() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                handleRequest(clientSocket);
            } catch (IOException e) {
                System.err.println("Failed to handle client request. Reason: " + e.getMessage());
            }
        }
    }

    private static void handleRequest(Socket clientSocket) {
        // Handle the client request here, this is a dummy operation.
        System.out.println("Handling client request");
    }
}