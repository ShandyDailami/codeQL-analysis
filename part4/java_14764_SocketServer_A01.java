import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14764_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Perform a secure operation (e.g., use an SSLSocket)
            // This is a placeholder for the actual secure operation
            // Here we're just accepting the connection and ignoring it
            clientSocket.getInputStream().read();

            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            clientSocket.close();
        }
    }
}