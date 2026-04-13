import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10314_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A07_AuthFailure
                // For the sake of simplicity, we'll just simulate this by checking if the client is authenticated
                if (isClientAuthenticated(client)) {
                    // If the client is authenticated, start a new thread for the communication with the client
                    new CommunicationThread(client).start();
                } else {
                    System.out.println("Authentication failed for client: " + client.getRemoteSocketAddress());
                    client.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred when accepting client connection: " + e.getMessage());
        }
    }

    // Simulate authentication by checking if a client's IP address matches a fixed set
    private static boolean isClientAuthenticated(Socket client) {
        String[] authorizedClients = {"127.0.0.1", "192.168.1.1"}; // Define the set of authorized clients
        String clientIp = client.getRemoteSocketAddress().toString();
        return ArrayUtils.contains(authorizedClients, clientIp);
    }

    private static class CommunicationThread extends Thread {
        private Socket client;

        public java_10314_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Perform communication with the client here using standard Java libraries
            // For the sake of simplicity, we'll just simulate this by echoing back the client's messages
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message from client: " + message);
                    writer.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error occurred when communicating with client: " + e.getMessage());
            }
        }
    }
}