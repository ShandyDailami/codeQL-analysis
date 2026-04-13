import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02340_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to port 4444
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            // Accept a client socket
            Socket client = server.accept();
            System.out.println("Client connected...");

            // Send a welcome message to the client
            String response = "Welcome to the server!\r\n";
            client.getOutputStream().write(response.getBytes());

            // Close the client socket
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}