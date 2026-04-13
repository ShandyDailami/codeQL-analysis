import java.io.*;
import java.net.*;

public class java_26598_SocketServer_A01 {
    private static final String SERVER_SOCKET = "serverSocket";
    private static final String CLIENT_SOCKET = "clientSocket";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            // Create Server Socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Accept client connection
            clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            // Write response to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Connected successfully");

        } catch (IOException e) {
            close(serverSocket, clientSocket);
            System.out.println("Exception caught when trying to listen on port " + PORT + " or listening for client connections");
        }

        // Close the connection
        close(serverSocket, clientSocket);
    }

    private static void close(Socket socket, ServerSocket serverSocket) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}