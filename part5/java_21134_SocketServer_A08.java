import java.io.*;
import java.net.*;

public class java_21134_SocketServer_A08 {

    private static final int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Start thread for handling client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error establishing server: " + e.getMessage());
       
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_21134_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Process message and send back
                processMessage(message);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
        // Close client connection
        closeConnection();
    }

    private void processMessage(String message) {
        // TODO: Implement message processing
    }

    private void closeConnection() {
        try {
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}