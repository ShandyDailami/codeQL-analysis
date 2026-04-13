import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16878_SocketServer_A03 {

    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            new Thread(() -> handleRequest(socket)).start();
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle the request here, e.g., reading data from the socket, processing it, etc.
        // For security-sensitive operations, do not directly read or write data from/to the socket.
        // Instead, use SSL/TLS to encrypt the data and ensure it's safe to transmit over the network.

        // For example, this is a placeholder for reading data from the socket:
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            System.out.println("Received: " + new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}