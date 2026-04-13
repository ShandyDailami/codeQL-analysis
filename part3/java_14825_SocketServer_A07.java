import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14825_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket on the specified port.
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Step 2: Wait for a client to connect.
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Step 3: Handle the request from the client.
            // This is a simplistic example, in a real application, you would likely
            // need to create a separate thread or use a more advanced networking
            // library to handle the request, perhaps in a non-blocking manner.
            // Also, this example does not implement authentication or security
            // so it's not really suitable for production use.
            String response = "Hello, client!";
            clientSocket.getOutputStream().write(response.getBytes());

            // Step 4: Close the connection.
            clientSocket.close();
        }
    }
}