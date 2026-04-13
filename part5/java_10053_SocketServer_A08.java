import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10053_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Process the request from the client
            // Here, we're just printing out the request
            // You would typically have a method here to process the request
            // For example, if the client sent a message, we'd print that message
            String request = new String(clientSocket.getInputStream().readNBytes(clientSocket.getInputStream().available()));
            System.out.println("Received request: " + request);

            // Send a response back to the client
            // Here, we're just echoing the request
            clientSocket.getOutputStream().write(request.getBytes());
            System.out.println("Sent response");

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}