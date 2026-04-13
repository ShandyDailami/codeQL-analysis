import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41496_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Set up server socket
            ServerSocket serverSocket = new SSLServerSocket(8080);
            System.out.println("Server started.");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Handle the client
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Get input and output streams
        // We could also use a simpler version of InputStreamReader and BufferedReader
        // Here, we'll be just printing the request from the client
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read request from client
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Send response to client
            String response = "HTTP/1.1 200 OK\n" + "Content-Type: text/plain\n\n" + "Hello, World!";
            writer.println(response);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}