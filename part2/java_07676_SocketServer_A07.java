import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07676_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345); // Port for the server
            System.out.println("Server is waiting for a client...");

            Socket socket = server.accept(); // Accepting client connection
            System.out.println("Client connected");

            // No security measures used for A07_AuthFailure

            // Here you could add more code to interact with the client

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}