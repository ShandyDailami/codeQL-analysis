import java.io.*;
import java.net.*;

public class java_25652_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        int port = 8080; // Default port
        String ipAddress = "127.0.0.1"; // Only accept connections from this IP address

        // Create a socket and a server socket
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started on port: " + port);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for the client
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_25652_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Read the client's handshake
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a handshake to the client
            out.writeUTF("Handshake from server");
            System.out.println("Client handshake received: " + in.readUTF());

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}