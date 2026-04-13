import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31183_SocketServer_A01 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // Send a greeting message to the client
                String response = "Hello, you connected to the server!\n";
                client.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}