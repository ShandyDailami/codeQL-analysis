import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28054_SocketServer_A03 {
    private static final int TRUSTED_NETWORK_PORT = 8080; // This port must be accessible from trusted devices

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(TRUSTED_NETWORK_PORT);
            System.out.println("Server is listening on port: " + TRUSTED_NETWORK_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Here you could add code to handle the socket, e.g., read/write operations
                // Please note that this is a simplistic example and does not include actual security measures
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}