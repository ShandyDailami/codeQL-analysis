import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28787_SocketServer_A01 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Establish a secure socket connection for communication
                Socket secureSocket = clientSocket.createSecureSocket();
                // ... (Perform security-sensitive operations here, e.g., SSLContext, KeyPair etc.)

                // ... (Handle communication with the client here)
            }
        } catch (IOException e) {
            e.printStackTrace();
        // handle the exception here, e.g., close the serverSocket
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}