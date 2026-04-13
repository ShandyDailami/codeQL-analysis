import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00225_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform secure operations here, for instance, encryption/decryption
                // of the client's data or other security-sensitive operations

                // Handle the client's data here

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}