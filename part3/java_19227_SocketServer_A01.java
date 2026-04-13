import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19227_SocketServer_A01 {

    private int port;
    private ServerSocket server;

    public java_19227_SocketServer_A01(int port) {
        this.port = port;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + port);
            System.exit(-1);
        }
    }

    public void startServer() {
        System.out.println("Server started on port " + port);

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Perform security-sensitive operations here.
                // In this example, we're just accepting any client. 
                // In a real-world scenario, you would typically want to restrict this to only the authorized clients.

                // Start new thread to handle client communication.
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("Failed to accept client connection.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).startServer();
    }
}

class ClientHandler extends Thread {

    private Socket client;

    public java_19227_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle client communication here.
        // In this example, we're just printing out the client's messages.
        // In a real-world scenario, you would typically want to send and receive data in a secure way.

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String message = reader.readLine();
                System.out.println("Client said: " + message);
            } catch (IOException e) {
                System.out.println("Failed to read from client.");
                e.printStackTrace();
            }
        }
    }
}