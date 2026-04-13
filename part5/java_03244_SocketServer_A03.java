import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_03244_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Create SSLServerSocket
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected!");

                // Send message to client
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Hello Client, Welcome to Vanilla Java Socket Server!");
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}