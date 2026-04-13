import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14441_SocketServer_A08 {
    private static boolean running = true;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started on port 8189");

            while (running) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create new thread for each client
                new ClientHandler(client);
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;

    public java_14441_SocketServer_A08(Socket client) {
        this.client = client;
        start();
    }

    @Override
    public void run() {
        // Handling client logic here. This is just a placeholder
        try {
            // Receive message from client
            String message = client.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Send response back to client
            client.getOutputStream().writeUTF("Message received");
            client.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}