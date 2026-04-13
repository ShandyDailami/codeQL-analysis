import java.io.*;
import java.net.*;
import java.util.*;

public class java_00520_SocketServer_A07 {

    // Define our server port
    private static final int SERVER_PORT = 8080;

    // Our main server thread
    public static void main(String[] args) {
        try {
            // Create a new server socket and listen on the specified port
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            // Keep the server running until we quit
            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    public java_00520_SocketServer_A07(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            // Create a new input stream from the client
            InputStream inputStream = clientSocket.getInputStream();

            // Create a new reader from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read the client's message
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Respond to the client
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Hello, client!");

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}