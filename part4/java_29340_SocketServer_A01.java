import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29340_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Closing the server socket after use
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        //  a. The program should not crash even if the server cannot be started.
        }
    }
}