import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15030_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // Here, we're assuming that the client is using a basic authentication mechanism.
                // In a real-world scenario, you would likely want to use a more secure mechanism.
                if (authenticateClient(clientSocket)) {
                    handleClient(clientSocket);
                } else {
                    System.out.println("Authentication failed. Client disconnected.");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implementation of client authentication would go here.
        // For the purpose of this example, we're just assuming the client is authenticated.
        return true;
    }

    private static void handleClient(Socket socket) {
        // Handle client communication here.
        // For the purpose of this example, we're just printing out messages from the client.
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}