import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25271_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Close the connection immediately.
                // The client should authenticate with a forgeries-resistant mechanism.
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}