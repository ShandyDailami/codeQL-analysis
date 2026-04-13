import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00926_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            // Handle client connection here
            // For simplicity, we're simply closing the connection
            socket.close();
        }
    }
}