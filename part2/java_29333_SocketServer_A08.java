import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29333_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Read from the socket
            // This is a dummy operation, replace it with your actual operation
            socket.getInputStream().read();

            // Close the connection
            socket.close();
        }
    }
}