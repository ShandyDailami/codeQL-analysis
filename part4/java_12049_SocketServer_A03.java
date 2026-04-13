import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12049_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Insecure way to create ServerSocket
        ServerSocket server = new ServerSocket(4444);

        System.out.println("Waiting for a client to connect...");

        // Insecure way to accept a connection
        Socket client = server.accept();

        System.out.println("Connection established with " + client.getRemoteSocketAddress());

        // Handle client connection insecurely
        // No security checks here, no data checking, no encoding etc.

        // Insecure way to close resources
        client.close();
        server.close();
    }
}