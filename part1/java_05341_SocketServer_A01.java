import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05341_SocketServer_A01 {
    private final int port;
    private boolean running = false;

    public java_05341_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        running = true;
        System.out.println("Starting server on port " + port);

        while (running) {
            try {
                ServerSocket server = new ServerSocket(port);
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                // This is a very basic example of checking if the client is authenticated.
                // In a real-world scenario, you would likely want to use a more secure method.
                if (authenticate(client)) {
                    handleClient(client);
                } else {
                    System.out.println("Client not authenticated");
                    client.close();
                }
            } catch (IOException e) {
                System.out.println("Failed to listen on port " + port);
                System.exit(-1);
            }
        }

        System.out.println("Stopped");
    }

    private boolean authenticate(Socket client) {
        // In a real-world scenario, you would likely want to use a more secure method.
        // This is a simple example.
        return true;
    }

    private void handleClient(Socket client) {
        // In a real-world scenario, you would likely want to use a more secure method.
        // This is a simple example.
    }

    public static void main(String[] args) {
        new SocketServer(1234).start();
    }
}