import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02519_SocketServer_A07 {
    private static final String AUTH_FAILURE = "Authentication failure";
    private static final int PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Send a predefined string to the client
                socket.getOutputStream().write((AUTH_FAILURE + "\n").getBytes());
                socket.getOutputStream().flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}