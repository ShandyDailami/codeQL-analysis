import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22279_SocketServer_A01 {

    private static final int PORT = 12345; // Change this to your preferred port

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Perform secure operation here
            // For example, accept the connection and handle the client's request
            // Here, we'll simply display a message to the client

            String response = "Welcome to the secure server!\n";
            clientSocket.getOutputStream().write(response.getBytes());

            clientSocket.close();
        }
    }
}