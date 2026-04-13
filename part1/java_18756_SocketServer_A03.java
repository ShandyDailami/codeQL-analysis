import java.net.ServerSocket;
import java.net.Socket;

public class java_18756_SocketServer_A03 {
    private static final String SERVER_NAME = "Vanilla Java SocketServer";
    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) {
        try {
            // Create a new ServerSocket that listens on the specified port
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is running on port " + SERVER_PORT);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle communication with the client
            handleCommunication(clientSocket);

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleCommunication(Socket socket) {
        // TODO: Implement your own logic for handling communication with the client
        // For example, we could read data from the socket, send data back to the client,
        // or perform other operations related to A03_Injection prevention
    }
}