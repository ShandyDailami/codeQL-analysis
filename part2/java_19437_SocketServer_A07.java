import java.io.*;
import java.net.*;
import java.util.*;

public class java_19437_SocketServer_A07 {
    // Define the port
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a socket server
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Accept a new connection
            Socket socket = serverSocket.accept();

            // Create a new thread to handle the connection
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_19437_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            // Create a buffered reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream writer = new DataOutputStream(output);

            // Read the client's message
            String clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            // Send back a response
            writer.write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}