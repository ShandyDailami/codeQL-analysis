import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12238_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

                // Handle the new connection in a new thread
                new Thread(() -> handleConnection(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleConnection(Socket socket) {
        // Here you can implement the logic for handling the connection.
        // For example, you could send a response to the client based on some data in the connection.
    }
}