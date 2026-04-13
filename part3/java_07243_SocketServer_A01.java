import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07243_SocketServer_A01 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // ...

                // Handle client communication
                // ...

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}