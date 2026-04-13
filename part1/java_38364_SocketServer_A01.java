import java.io.*;
import java.net.*;
import java.util.*;

public class java_38364_SocketServer_A01 {

    public static void main(String[] args) {
        // Create a server socket
        ServerSocket server = null;
        try {
            server = new ServerSocket(6789);
            System.out.println("Waiting for client connections...");
            Socket socket = null;
            while (true) {
                // Accept a new client
                socket = server.accept();
                System.out.println("Client connected!");
                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_38364_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a buffered reader and writer
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            writer.println("Welcome to the server!");

            // Read and respond to each client's message
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println("Server says: Hello, " + message);
            }

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}