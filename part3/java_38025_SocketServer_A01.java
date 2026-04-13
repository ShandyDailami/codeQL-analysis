import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38025_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Perform security-sensitive operations
                // In a real-world scenario, these operations would involve
                // reading and writing data to/from the socket, using secure channels,
                // and checking the authentication credentials of the client.

                // For simplicity, we'll just close the connection here.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}