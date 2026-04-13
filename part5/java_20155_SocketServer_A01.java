import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20155_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, the client connection is established.
                // For the sake of security, we're not performing any operations related to A01_BrokenAccessControl here.

                // After the client is connected, we're handling the communication here.
                // For instance, we're reading the client's request and sending a response.

                // ...

                // Closing the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}