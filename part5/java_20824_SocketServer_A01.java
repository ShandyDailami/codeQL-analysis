import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_20824_SocketServer_A01 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(LOCALHOST, PORT));
            System.out.println("Server started on " + LOCALHOST + " port " + PORT);

            while (true) {
                SocketChannel client = server.accept();
                System.out.println("Client connected from: " + client.socket().getRemoteSocketAddress());

                // Only allow connections from a specific IP address
                String clientIP = client.socket().getRemoteSocketAddress().toString().substring(1);
                if (!clientIP.equals("localhost") && !clientIP.equals("127.0.0.1")) {
                    System.out.println("Connection from " + clientIP + " was rejected");
                    client.close();
                    continue;
                }

                // Handle the client connection here, e.g., start a new thread for each client connection
                // clientConnectionHandler(client);

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}