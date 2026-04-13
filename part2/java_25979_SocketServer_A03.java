import java.io.*;
import java.net.*;

public class java_25979_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Perform operations in a new thread
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_25979_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the incoming request
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Send a response
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String response = "Hello, client!";
            writer.println(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}