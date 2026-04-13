import java.net.ServerSocket;
import java.net.Socket;

public class java_04292_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for handling each client
                new ClientHandler(client).start();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while running the server " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;

    public java_04292_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Receive the message from the client
            byte[] bytes = new byte[1000];
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message = reader.readLine();

            // Echo the message back to the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Server received: " + message);

            client.close();
        } catch (Exception e) {
            System.out.println("Error occurred while handling client " + e.getMessage());
        }
    }
}