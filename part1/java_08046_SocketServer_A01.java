import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08046_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Close the connection as soon as a client connects.
            // This violates the Broken Access Control principle.
            socket.close();
        }
    }
}