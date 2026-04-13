import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10464_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // A07_AuthFailure: Implement authentication logic here
            // For simplicity, let's assume we accept all connections for now

            // Handle the client's request or response here

            socket.close();
        }
    }
}