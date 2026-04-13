import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15083_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // This will not work in a real-world application, as it allows anyone to connect to the server.
            // It's just a simple example of a secure server.
            // In a real-world application, you should implement security measures like SSL/TLS, username/password authentication, etc.
            // socket.close();
        }
    }
}