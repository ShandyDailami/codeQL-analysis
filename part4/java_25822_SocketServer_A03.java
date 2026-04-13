import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25822_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(0); // Listening on any available port
            System.out.println("Server is listening on port: " + server.getLocalPort());
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                // No need to do anything here, just accepting the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}