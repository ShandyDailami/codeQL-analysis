import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03271_SocketServer_A01 {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Here you can implement your secure communication protocol
                // e.g. use SSL/TLS for data encryption/decryption, use Authentication/Authorization
                // for secure user authentication and authorization
                // e.g. use SSLContext for handling SSL/TLS, use Socket.getInputStream() and Socket.getOutputStream() for IO operations
                // e.g. use a MessageAuthenticationCode (MAC) for secure message authentication
                // e.g. use a SecretKey for symmetric encryption/decryption

                // For now, we'll just pass the connection to a new thread for simplicity
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to setup server socket: " + e.getMessage());
        }
    }
}