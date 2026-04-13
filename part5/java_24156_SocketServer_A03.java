import java.io.*;
import java.net.*;

public class java_24156_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Step 1: Initialize the ServerSocket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started!");

        while (true) {
            // Step 2: Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Step 3: Create a new thread for handling the client communication
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_24156_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Step 4: Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 5: Send a welcome message to the client
            out.println("Welcome to the server!");

            // Step 6: Receive and echo a message from the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message from client: " + message);
                out.println("Server echo: " + message);
            }

            // Step 7: Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}