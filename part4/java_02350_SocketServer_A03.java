import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02350_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Enter an infinite loop to keep the server running
        while (true) {
            // Accept a new client connection
            Socket socket = serverSocket.accept();

            // Create a new thread for each client connection
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}