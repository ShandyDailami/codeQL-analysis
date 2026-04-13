import java.io.*;
import java.net.*;

public class java_17704_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is listening on port " + PORT);

        // Create a socket using the specified port
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for this client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
        }
    }
}

class ClientHandler implements Runnable {

    private final Socket socket;

    public java_17704_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            // Read incoming message
            DataInputStream in = new DataInputStream(input);
            DataOutputStream out = new DataOutputStream(output);

            // Write outgoing message
            String message = in.readUTF();
            out.writeUTF("Message received: " + message);

        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }
}