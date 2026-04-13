import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32583_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Here you can handle the client connection and process requests
                // However, for security purposes, we'll simulate that a client is trying to connect to the server
                // without properly implementing access control. In a real application, you would instead handle
                // the connection request in a more secure manner.
                clientSocket.getOutputStream().write((
                        "HTTP/1.1 200 OK\n" +
                                "Content-Type: text/plain; charset=utf-8\n\n" +
                                "Hello, World!").getBytes());
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT + ": " + e.getMessage());
        }
    }
}