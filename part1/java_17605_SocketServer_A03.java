import java.io.*;
import java.net.*;

public class java_17605_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is running on port 1234...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_17605_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Inject code here to perform some security-sensitive operation
            // For example, this code will remove all characters that are not letters
            String sanitizedMessage = message.replaceAll("[^a-zA-Z]", "");

            // Send the sanitized message back to the client
            out.println("Sanitized message: " + sanitizedMessage);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}