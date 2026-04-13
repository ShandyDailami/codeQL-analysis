import java.net.Socket;
import java.net.ServerSocket;

public class java_02871_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345); // Creates a server socket on port 12345
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket client = server.accept(); // Waits for a client to connect
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_02871_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Read the client's message
            String message = client.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            client.getOutputStream().writeUTF("Server received your message");
            client.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}