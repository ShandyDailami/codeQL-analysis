import java.io.*;
import java.net.*;

public class java_36415_SocketServer_A01 {
    private static final String SERVER_STATE = "Server is running...";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Step 1: Set up a socket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Step 2: Accept client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Step 3: Handle client communication
                handleClientCommunication(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred when trying to setup the server or accept the client connection");
            e.printStackTrace();
        }
    }

    private static void handleClientCommunication(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Step 4: Send a response to the client
                String serverMessage = "Server says: " + clientMessage;
                out.println(serverMessage);
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred while handling client communication");
            e.printStackTrace();
        }
    }
}