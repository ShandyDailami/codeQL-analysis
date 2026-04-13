import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11260_SocketServer_A07 {
    private static final int PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {
        System.out.println("Server is waiting for connections on port " + PORT + "...");

        try {
            server = new ServerSocket(PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected to the server!");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServer();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle client here, this is just a placeholder
    }

    private static void closeServer() {
        System.out.println("Server is shutting down...");
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}