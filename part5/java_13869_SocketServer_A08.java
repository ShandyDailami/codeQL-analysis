import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13869_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                // Perform security-sensitive operations here
                // For example, checking if the integrity of the received data is valid
                // If it's not valid, reject the connection
                // You can use libraries like java.security for more complex checks
                // For example, java.security.MessageDigest or java.security.Signature

                // For simplicity, we just check the integrity of the received data
                // Here, we're assuming that the integrity check is a simple length check
                if (socket.getInputStream().available() < 1) {
                    System.out.println("Integrity check failed. Connection rejected.");
                    socket.close();
                } else {
                    System.out.println("Integrity check passed. Connection accepted.");
                    // Handle the client connection in a separate thread
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}