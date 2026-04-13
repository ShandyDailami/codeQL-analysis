import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30053_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a server socket
        ServerSocket server = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        // accept client connections
        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected");

            // handle client communication
            // create a new thread for handling the client communication
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        // read from the client
        // handle the read operation
        // write to the client
    }
}