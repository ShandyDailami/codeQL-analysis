import java.io.*;
import java.net.*;
import java.util.*;

public class java_29318_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(67);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new Thread for each client
            new HandleClientThread(client).start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket client;

    public java_29318_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Create a new input stream and output stream for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Read the client's message
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send a "Hello, World!" message back to the client
            out.println("Hello, World!");
            out.flush();

            // Close the streams
            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}