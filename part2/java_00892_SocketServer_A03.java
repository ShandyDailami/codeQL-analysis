import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00892_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected!");

            // Create a new thread for the client
            new Thread(() -> {
                // Handle client communication
                handleClientCommunication(socket);
            }).start();
        }
    }

    private static void handleClientCommunication(Socket socket) {
        // TODO: Add code to handle client communication
    }
}