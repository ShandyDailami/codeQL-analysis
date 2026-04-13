import java.io.*;
import java.net.*;

public class java_30054_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a socket that listens for incoming connections on port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            // Wait for a client to connect
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Start a new thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_30054_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error creating I/O streams");
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Send a welcome message to the client
            out.println("Welcome to the server! You are connected from " + socket.getRemoteSocketAddress());

            String message;
            while ((message = in.readLine()) != null) {
                // Process incoming message
                System.out.println("Received: " + message);
                // Send a reply back to the client
                out.println("Server: I received your message");
            }
        } catch (IOException e) {
            System.out.println("Error handling client");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket");
                e.printStackTrace();
            }
        }
    }
}