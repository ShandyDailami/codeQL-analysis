import java.io.*;
import java.net.*;
import java.util.*;

// SocketServer to accept client connections
public class java_32181_SocketServer_A08 {
    // The server port
    private static final int SERVER_PORT = 8000;
    // Socket for client communication
    private Socket clientSocket;
    // InputStream from client
    private InputStream inputStream;
    // OutputStream to client
    private OutputStream outputStream;

    // Main method
    public static void main(String[] args) {
        new SocketServer().startServer();
    }

    // Start the server
    public void startServer() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port: " + SERVER_PORT);

            // Accept a client socket
            clientSocket = serverSocket.accept();

            // Set up input and output streams
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();

            // Create a new thread for client communication
            ClientHandler clientHandler = new ClientHandler(clientSocket, inputStream, outputStream);
            Thread clientThread = new Thread(clientHandler);
            clientThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Handles client communication
class ClientHandler implements Runnable {
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public java_32181_SocketServer_A08(Socket clientSocket, InputStream inputStream, OutputStream outputStream) {
        this.clientSocket = clientSocket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            // Send a welcome message
            outputStream.write("Welcome to the server!\n".getBytes());

            // Read the client's message
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder message = new StringBuilder();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                message.append(new String(buffer, 0, bytesRead));
            }

            // Print the received message
            System.out.println("Received message: " + message);

            // Respond to the client
            outputStream.write("Thank you for connecting!\n".getBytes());

            // Close the client socket
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}