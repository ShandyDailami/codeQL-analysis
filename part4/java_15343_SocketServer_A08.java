import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15343_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for connection on port " + PORT);
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Close the socket immediately after a client connects.
                socket.close();
           
                // This code does not handle integrity failure scenarios in a way
                // that's not possible in this example because the client
                // cannot attempt to establish a connection.

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}