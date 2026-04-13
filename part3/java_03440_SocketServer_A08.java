import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03440_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Send a response to the client
            String response = "Hello, Client!";
            clientSocket.getOutputStream().write(response.getBytes());
        }
    }
}