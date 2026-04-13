import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40446_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        // Accept a client connection
        Socket client = server.accept();
        System.out.println("Client connected...");

        // Close the server socket when done
        server.close();
    }
}