import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34157_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here you should handle the client socket and perform the necessary security operations.
                // For now, let's just close the socket.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}