import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13580_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");

                new Thread(() -> handleClient(clientSocket))
                        .start();
            }
        } catch (IOException ex) {
            System.out.println("Error with server: " + ex.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        // TODO: Implement client handling logic here.
    }
}