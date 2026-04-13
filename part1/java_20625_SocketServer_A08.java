import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20625_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // We use the keytabhenticator for secure server
                client.setNeedClientAuthentication(true);
                client.setEnabledCipherSuites(new String[]{"SSL_RSA_WITH_AES_128_CBC_SHA", "SSL_DSS_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DSS_WITH_AES_128_CBC_SHA"});
                client.setAvailableProcessors(4);

                // Start a new thread for handling the client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;

    public java_20625_SocketServer_A08(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle client here
    }
}