import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class java_39671_SocketServer_A01 {

    private static final String LOCALHOST = "127.0.0.1";
    private static final int PORT = 9000;
    private static final Set<InetAddress> authorizedClients = new HashSet<>();

    static {
        try {
            InetAddress localhost = InetAddress.getByName(LOCALHOST);
            authorizedClients.add(localhost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running...");

        while (true) {
            Socket client = server.accept();
            InetAddress clientAddress = client.getInetAddress();

            if (authorizedClients.contains(clientAddress)) {
                System.out.println("Client " + clientAddress.getHostAddress() + " is authorized to connect!");
                // Start a new thread for each client to handle communication
                new HandleClient(client).start();
            } else {
                System.out.println("Client " + clientAddress.getHostAddress() + " is not authorized!");
                client.close();
            }
        }
    }

    private static class HandleClient extends Thread {
        private Socket client;

        public java_39671_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle communication here with client
        }
    }
}