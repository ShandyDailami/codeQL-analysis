import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06389_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected: " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // here we can add code to handle client operations, but not really dealing with security at this level
        // since we're focusing on A08_IntegrityFailure, which is about ensuring data integrity, we're not really adding that functionality here
    }
}