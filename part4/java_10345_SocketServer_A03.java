import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10345_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Implement your security-sensitive operations here
                // For now, we'll just accept the connection and drop the client
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}