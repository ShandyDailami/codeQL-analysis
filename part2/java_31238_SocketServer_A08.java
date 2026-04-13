import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31238_SocketServer_A08 {
    private static final int PORT = 4445; // Port to listen on

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Send a response
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}