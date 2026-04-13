import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30961_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Handle the client socket
        handleClient(clientSocket);
   
        // Close the server socket
        serverSocket.close();
    }

    private static void handleClient(Socket clientSocket) {
        // You can handle the client socket here
        // For example, you can create a new thread and start a new thread for each client

        // Here is a very basic example
        new Thread(() -> {
            while (true) {
                try {
                    // Receive a message from the client
                    String message = clientSocket.getInputStream().readUTF();
                    System.out.println("Received: " + message);

                    // Send a response back to the client
                    clientSocket.getOutputStream().writeUTF("Hello, client!");
                    clientSocket.getOutputStream().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}