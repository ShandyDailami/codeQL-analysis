import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38844_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a new server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Send a message back to the client
            clientSocket.getOutputStream().write("Hello, client!".getBytes());

            // Close the connection
            clientSocket.close();
        }
    }
}