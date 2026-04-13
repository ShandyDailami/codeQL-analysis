import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23862_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a new server socket with a specific port
            ServerSocket server = new ServerSocket(8080);

            System.out.println("Waiting for client...");

            // Accept incoming connection
            Socket socket = server.accept();

            System.out.println("Client connected");

            // Close the server socket
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}