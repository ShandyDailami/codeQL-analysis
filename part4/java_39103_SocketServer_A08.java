import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39103_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Perform integrity checks here, such as checking if the socket is valid and the other end is valid
            // For this example, let's just print out the message to the console
            System.out.println("Received: " + socket.getInputStream().read());

            // Close the socket here after handling the message
            socket.close();
        }
    }
}