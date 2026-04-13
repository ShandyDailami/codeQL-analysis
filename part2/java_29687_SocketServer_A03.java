import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29687_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client request
                handleClientRequest(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while processing requests: " + e.getMessage());
        }
    }

    private static void handleClientRequest(Socket clientSocket) {
        try {
            // Read from the client
            String request = "";
            int requestSize = 0;
            byte[] buffer = new byte[1024];
            while ((requestSize = clientSocket.getInputStream().read(buffer)) != -1) {
                request += new String(buffer, 0, requestSize);
            }

            // Process the request
            // Here, we simply return a static response
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain; charset=UTF-8\r\n" +
                    "Content-Length: " + request.length() + "\r\n" +
                    "\r\n" +
                    request;

            // Send the response back to the client
            clientSocket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            System.out.println("Error occurred while handling client request: " + e.getMessage());
        }
    }
}