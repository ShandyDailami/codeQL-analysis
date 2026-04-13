import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19255_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // Create a new thread to handle communication with the client
                new HandlerThread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for client connections: " + e.getMessage());
        }
    }
}

class HandlerThread extends Thread {
    private final Socket client;

    public java_19255_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle communication with the client here
        // This is a simplistic example where we simply print out a message
        try {
            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = client.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);

            // Echo the message back to the client
            client.getOutputStream().write(("Echo: " + message).getBytes());
            client.getOutputStream().flush();

            // Close the connection
            client.close();
        } catch (IOException e) {
            System.out.println("Error occurred while handling communication with client: " + e.getMessage());
        }
    }
}