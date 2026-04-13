import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40535_SocketServer_A03 {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port: " + SERVER_PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle client connection here, for now we'll just shut down the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}