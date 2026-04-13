import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40931_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for connections on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Here you could handle each new connection in a separate thread
                // new ConnectionHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}