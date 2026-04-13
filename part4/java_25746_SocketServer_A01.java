import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25746_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started on port 1234");

        // Infinite loop to keep server running
        while (true) {
            // Accept a new client socket
            Socket socket = serverSocket.accept();

            // Handle the client socket
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        // TODO: Implement security-sensitive operations related to Broken Access Control

        // Close the socket to prevent new connections
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}