import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20880_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations here
                // ...

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}