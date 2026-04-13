import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20744_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Send a message to the client
            clientSocket.getOutputStream().write("Hello, client!".getBytes());
        }
    }
}