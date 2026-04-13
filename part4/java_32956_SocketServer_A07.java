import java.net.ServerSocket;
import java.net.Socket;

public class java_32956_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 12345; // port to listen on

        // Create a new server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Accept a new client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client connection
            handleClientConnection(clientSocket);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
       
        }
    }

    private static void handleClientConnection(Socket socket) {
        // Here you can add your authentication logic.
        // For this example, we'll just assume the client is authenticated
        try {
            // Read from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);
            socket.getOutputStream().flush();

        } catch (Exception e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }
}