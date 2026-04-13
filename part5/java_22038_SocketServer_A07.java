import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_22038_SocketServer_A07 {
    private static final String WHITE_LIST = "127.0.0.1"; // restrict connections only from this IP
    private static final Map<String, String> AUTH_MAP = new HashMap<>(); // for basic authentication

    static {
        AUTH_MAP.put("admin", "password");
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                if (isClientAuthorized(client)) {
                    new ClientHandler(client).start();
                } else {
                    System.out.println("Client " + client.getRemoteSocketAddress() + " is not authorized");
                    client.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    private static boolean isClientAuthorized(Socket client) {
        String clientIp = client.getRemoteSocketAddress().toString();
        return WHITE_LIST.contains(clientIp) && AUTH_MAP.containsKey(clientIp) &&
                AUTH_MAP.get(clientIp).equals(getPasswordFromClient(client));
    }

    private static String getPasswordFromClient(Socket client) {
        // In a real application, you would typically read the password from the client socket
        // Here we just return a predefined password
        return "password";
    }

    private static class ClientHandler extends Thread {
        private Socket client;

        public java_22038_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // You can read from and write to the client here
        }
    }
}