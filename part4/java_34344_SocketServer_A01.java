import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34344_SocketServer_A01 {

    private int port;
    private ServerSocket server;

    public java_34344_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
       .
.
.
        // Handle exceptions here
    }

    public void stop() {
        try {
            server.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            System.out.println("Failed to stop server: " + e.getMessage());
        }
    }

    private class ClientHandler extends Thread {
        private Socket client;

        public java_34344_SocketServer_A01(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Handle client communication here
            } catch (IOException e) {
                System.out.println("Failed to handle client communication: " + e.getMessage());
            }
        }
    }
}