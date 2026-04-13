import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15772_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        // Infinite loop to keep the server running
        while (true) {
            // Accept a new client
            Socket socket = serverSocket.accept();

            // Print a message to the client
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
       
            // Here, we're assuming the client is a human and doesn't want to give away sensitive information
            // You would want to add more secure code here for more complex situations, such as implementing a secure handshake
            // or encrypting data on the client side

            // Now, you could send and receive data as normal, but for this example, we're not doing anything
            // socket.getInputStream().read();
            // socket.getOutputStream().write();
        }
    }
}