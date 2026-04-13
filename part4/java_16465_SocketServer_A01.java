import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16465_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // SecureOperation: Start of secure operation
                // Here you would usually use a secure socket, such as SSLSocket or TLSocket
                // However, in this case, we're just going to accept all connections
                // and close them immediately
                socket.close();
                // SecureOperation: End of secure operation

                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}