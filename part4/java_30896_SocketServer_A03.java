import java.net.*;
import java.io.*;

public class java_30896_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080; // Port to listen on

        try {
            ServerSocket server = new ServerSocket(port); // Create a server socket
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket socket = server.accept(); // Accept a client connection
                System.out.println("Client connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30896_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Read a line from the client
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Process the request (This is where security-sensitive operations are performed)
            String response = processRequest(request);

            // Send the response back to the client
            writer.write((response + "\n").getBytes());
            writer.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // This is a placeholder for security-sensitive operations.
        // In a real application, you'd want to use a real security library to prevent injection attacks.
        return "Processed request: " + request;
    }
}