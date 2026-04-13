import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25805_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we are only checking if the socket is connected
            // and if not, we are closing the connection
            if (socket.isConnected()) {
                // Your code related to integrity failure here
                // For now, we're just printing out the message
                System.out.println("A08_IntegrityFailure detected!");
            }

            socket.close();
        }
    }
}