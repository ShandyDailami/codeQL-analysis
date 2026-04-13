import java.io.*;
import java.net.*;

public class java_28853_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new client
                Socket client = server.accept();
                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected!");

                // Create a new thread for the client
                Handler handler = new Handler(client);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_28853_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            out.println("Welcome to the server!");

            // Handle incoming messages
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // TODO: Implement security-sensitive operations related to A08_IntegrityFailure.
                // For example, check if the message contains a password.

                // TODO: If the message is authenticated, use it.
                // For example, replace the message with a greeting message.

                // TODO: If not, return an error message.
                // For example, respond with an error message.

                // TODO: Close the connection.
                // For example, respond with a farewell message and close the connection.

                // TODO: Handle exceptions.
                // For example, log the exception and continue.
            }

            // Close the connection
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}