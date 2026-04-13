import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22756_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the socket connection here.
                // This is just a placeholder, you'll need to handle multiple clients and their requests.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}