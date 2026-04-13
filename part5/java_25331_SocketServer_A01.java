import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class java_25331_SocketServer_A01 {
    private static final String PASSWORD = "securePassword"; // Hard-coded password
    private static HashMap<String, InetAddress> connectedClients = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(54321, 100);
            System.out.println("Server started on port 54321");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getInetAddress().getHostAddress());

                // Authenticate client
                String clientPassword = client.getInputStream().readUTF();
                if (!PASSWORD.equals(clientPassword)) {
                    System.out.println("Client " + client.getInetAddress().getHostAddress() + " failed to connect.");
                    client.close();
                    continue;
                }

                connectedClients.put(client.getInetAddress().toString(), client.getInetAddress());

                // Start handling client's request here
                new ClientHandler(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;

        public java_25331_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Send client's password
                client.getOutputStream().writeUTF(PASSWORD);
                client.getOutputStream().flush();

                // Read and echo back the request
                while ((client.getInputStream().readUTF()) != null) {
                    // Echo back request
                    client.getOutputStream().writeUTF(client.getInputStream().readUTF());
                    client.getOutputStream().flush();
                }

                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}