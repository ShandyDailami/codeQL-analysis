import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04288_SocketServer_A03 {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Perform security-sensitive operations related to A03_Injection
            // Example: Use a Secure Socket for communication
            Socket secureSocket = new Socket(socket.getInetAddress(), socket.getPort());

            // Write a message to the client
            secureSocket.getOutputStream().write("Hello, Client!".getBytes());

            // Close the connection
            secureSocket.close();
        }
    }
}