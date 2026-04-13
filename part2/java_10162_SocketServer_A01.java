import java.io.*;
import java.net.*;

public class java_10162_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle each client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket client;

    public java_10162_SocketServer_A01(Socket client) {
        this.client = client;
    }

    public void run() {

        try {
            // Get the input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Receive the client's request
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Process the request (e.g., perform some action)
            // ...

            // Send a response back to the client
            out.println("Server says: Hello, client!");

            // Close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}