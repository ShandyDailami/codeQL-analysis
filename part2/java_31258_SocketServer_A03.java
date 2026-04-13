import java.io.*;
import java.net.*;

public class java_31258_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444); // Listens on port 4444
        System.out.println("Server started on port 4444");

        while (true) { // Continually listen for connections
            Socket socket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_31258_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            close();
        }
    }

    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) { // Read client's message
                System.out.println("Received: " + message);
                // Process the message in a way that's safe against injection
                // For now, just send back the received message
                writer.println("Received: " + message);
                writer.flush();
            }
        } catch (Exception e) {
            close();
        }
    }

    private void close() {
        try {
            socket.close();
            reader.close();
            writer.close();
        } catch (Exception e) {
            // Ignore exception, it's okay to leave the resources open
        }
    }
}