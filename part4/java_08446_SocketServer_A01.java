import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08446_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected!");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle client here. This could be as simple as printing a message or as complex as handling a secure communication with a client.
        // For simplicity, we'll print out the socket's IP address and port.
        try {
            String clientIp = socket.getInetAddress().getHostAddress();
            int clientPort = socket.getPort();
            System.out.println("Client connected from IP: " + clientIp + ", Port: " + clientPort);

            // Close the socket after handling the client
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}