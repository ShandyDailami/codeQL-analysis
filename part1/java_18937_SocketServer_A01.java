import java.io.*;
import java.net.*;

public class java_18937_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a new server socket and wait for client connections
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_18937_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the client's message
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Simulate a security issue by echoing the message back
            out.writeBytes(message + "\n");
            out.flush();

            // Close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}