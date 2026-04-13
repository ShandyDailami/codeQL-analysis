import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26925_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection separately
                // Here we are only printing the message and not doing any security-sensitive operations
                // In reality, you would need to use the established socket for communication.
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Here you would handle communication with the client.
        // For now, we just print out the message received from the client.
        System.out.println("Received: " + socket.getInputStream().read());
    }
}