import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33891_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            // Perform security-sensitive operations here
            // For example, check if the client is authenticated and if it has access to the requested resource
            // If not, deny access and close the connection

            // ...

            // Close the connection
            socket.close();
        }
    }
}