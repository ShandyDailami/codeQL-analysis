import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08085_SocketServer_A08 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                new Handler(clientSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}