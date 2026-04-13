import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17991_SocketServer_A08 {
    private static final int SERVER_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Perform integrity check after connection
                performIntegrityCheck(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Error while setting up the server socket: " + e.getMessage());
        } finally {
            stopServer();
        }
    }

    private static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("Server has stopped!");
        } catch (IOException e) {
            System.err.println("Error while closing the server socket: " + e.getMessage());
        }
    }

    private static void performIntegrityCheck(Socket clientSocket) {
        // Insert your integrity check code here
        // For simplicity, we will just print a message
        System.out.println("Performing integrity check...");
    }
}