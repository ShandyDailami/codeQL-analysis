import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class java_20440_SocketServer_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Set the host and port for the server
        String host = "localhost";
        int port = 8080;

        // Start the server
        startServer(host, port);

        // Wait for a while before shutting down
        TimeUnit.SECONDS.sleep(60);

        // Stop the server
        stopServer();
    }

    private static void startServer(String host, int port) throws IOException {
        // Create a new server socket
        Socket serverSocket = new Socket(host, port);

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Read a line from the client
        String clientMessage = in.readLine();

        // Process the message
        processMessage(clientMessage, in, out);

        // Close the socket
        serverSocket.close();
    }

    private static void processMessage(String clientMessage, BufferedReader in, PrintWriter out) {
        // Encrypt the client message
        String serverMessage = encryptMessage(clientMessage);

        // Send the server message back to the client
        out.println(serverMessage);
    }

    private static String encryptMessage(String message) {
        // This is a simple example of encryption. In a real-world scenario, this would be replaced with a more complex encryption algorithm.
        return new StringBuilder(message).reverse().toString();
    }

    private static void stopServer() {
        // This is a placeholder for any cleanup code. In a real-world scenario, this would be replaced with code to stop the server.
        System.out.println("Server stopped.");
    }
}