import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14695_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a new server socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            // Create a new thread to handle communication with the client
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // TODO: Handle the communication with the client
        // This is where you should implement the security-sensitive operations related to A01_BrokenAccessControl
    }
}