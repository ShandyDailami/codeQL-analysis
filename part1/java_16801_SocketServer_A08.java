import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16801_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            // Here you can add security measures such as SSL/TLS, authentication, etc.
            // However, as per the problem requirements, this part is not included here

            // Handle the client connection
        }
    }
}