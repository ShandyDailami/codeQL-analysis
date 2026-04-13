import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25500_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket and listen for incoming connections.
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444.");

        // Accept a new connection.
        Socket socket = server.accept();
        System.out.println("A new client has connected.");

        // Send a response to the client.
        String response = "Hello, client!";
        socket.getOutputStream().write(response.getBytes());

        // Close the connection.
        socket.close();
        server.close();
    }
}