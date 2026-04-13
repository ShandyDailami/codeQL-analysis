import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04459_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Add your code here for handling the socket connection and communication
            // with the client, e.g., by reading and writing data.

            socket.close();
        }
    }
}