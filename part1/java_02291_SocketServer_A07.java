import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02291_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here we use the SSLSocket for secure communication
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true);

                // Use a custom Authenticator for client
                sslSocket.setAuthenticationHandler(new MyAuthenticationHandler());

                // Continue with server logic...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}