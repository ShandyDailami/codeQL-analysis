import java.io.*;
import java.net.*;

public class java_05853_SocketServer_A03 {

    // The server socket
    private ServerSocket server;

    public java_05853_SocketServer_A03(int port) throws IOException {
        // Create a server socket and bind it to the port
        server = new ServerSocket(port);
    }

    public void startServer() {
        // This loop will continue until we stop it
        while (true) {
            try {
                // Accept a new client
                Socket client = server.accept();

                // Create a new thread for this client
                ClientHandler handler = new ClientHandler(client);
                handler.start();
            } catch (IOException ex) {
                System.out.println("Error accepting client: " + ex.getMessage());
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Create a new server and start it
        SecureSocketServer server = new SecureSocketServer(8080);
        server.startServer();
    }
}

class ClientHandler extends Thread {
    // The socket from the client
    private Socket client;

    public java_05853_SocketServer_A03(Socket socket) {
        this.client = socket;
    }

    public void run() {
        try {
            // Create a new input stream for this client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Read the client's message
            String message = reader.readLine();

            // Process the message (in this case, simply echo it back)
            String response = processMessage(message);

            // Write the response back to the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println(response);
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }

    private String processMessage(String message) {
        // This is a simple example of a message processing function.
        // It simply returns the message unchanged.
        // This function is used to demonstrate security-sensitive operations related to injection.
        return message;
    }
}