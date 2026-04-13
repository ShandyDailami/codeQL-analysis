import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17721_SocketServer_A08 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Here, we are using a simple A08_IntegrityFailure prevention strategy:
                // We will just close the socket and don't check for the integrity of the data received
                // This is a simple demonstration and may not be suitable for all use-cases
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}