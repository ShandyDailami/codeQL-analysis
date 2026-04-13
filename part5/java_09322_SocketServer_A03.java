import java.io.*;
import java.net.*;

public class java_09322_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_09322_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            writer.println("Welcome to the server!");

            // Handle incoming messages
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Check for suspicious activities
                if (message.contains("bad_word")) {
                    System.out.println("Suspicious activity detected!");
                    writer.println("Suspicious activity detected!");
                } else {
                    writer.println("Message received successfully!");
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}