import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21713_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Step 1: Set up a server socket
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            // Step 2: Accept client connection
            Socket socket = serverSocket.accept();

            // Step 3: Handle client connection
            // Here we use a creative twist of security-sensitive operations
            // We generate a random username and password
            String username = "User" + ((int) (Math.random() * 100));
            String password = "Password" + ((int) (Math.random() * 100));

            // Step 4: Send username and password to client
            socket.getOutputStream().write((username + ":" + password).getBytes());

            // Step 5: Close the connection
            socket.close();
        }
    }
}