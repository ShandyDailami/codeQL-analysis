import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26454_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for client connection...");

            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Send a welcome message to the client
            socket.getOutputStream().write("Welcome to the server!\n".getBytes());

            // Close the socket
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}