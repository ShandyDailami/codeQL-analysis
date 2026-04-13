import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07645_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Perform secure operations here, such as encryption, decryption, etc.
                // For example, you can use SSL/TLS to secure the communication with the client
                // This is just a simple example, in a real-world application, you would need to use
                // a more secure method of communication, such as HTTPS or JWT
                // Note: The following code does not include the implementation of secure communication

                // Handle the communication with the client here

                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start due to: " + e.getMessage());
            e.printStackTrace();
        }
    }
}