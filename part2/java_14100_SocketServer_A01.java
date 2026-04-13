import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14100_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here, we're not using a thread for each client, and not implementing any security measures
                // This is a very basic example and it's not suitable for a production environment
                new Thread(() -> {
                    handleClient(socket);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client here, for example, by reading and writing data
        // You may use a BufferedReader and PrintWriter to read and write data from the client
    }
}