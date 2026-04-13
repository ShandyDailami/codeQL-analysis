import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04795_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a server socket with a predefined port
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        // Infinite loop to accept new connections
        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected");

            // Handle the client connection here
            // This is a simplified example, in a real application you would need to implement authentication and handle multiple clients
            // For the sake of this example, we'll just print out the received message
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Read a message from the client
        // This is a simplified example, in a real application you would need to implement authentication
        // For the sake of this example, we'll read a string from the client and print it
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Server received your message: " + message);

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Failed to handle client");
            e.printStackTrace();
        }
    }
}