import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10037_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        // Accept a client connection
        Socket socket = serverSocket.accept();

        // Process the client connection here

        // Close the connection
        socket.close();
    }
}