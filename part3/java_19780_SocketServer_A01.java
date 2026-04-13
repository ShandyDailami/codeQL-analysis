import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_19780_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a new socket server on port 4444
        java.net.ServerSocket server = new java.net.ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_19780_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Create a new reader for the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Create a new writer for the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            // Read a message from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            writer.println("Server: Hello, client!");
            System.out.println("Sent: " + writer.toString());

            // Close the connection
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}