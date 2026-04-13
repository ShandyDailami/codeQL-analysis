import java.io.*;
import java.net.*;
import java.util.*;

public class java_11711_SocketServer_A07 {
    public static void main(String[] args) {
        // Create a socket
        ServerSocket serverSocket = null;

        try {
            // Bind the socket to a port
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accept incoming connections
        Socket socket = null;

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create a new thread for each client
            new ClientThread(socket).start();
        }
    }
}

class ClientThread extends Thread {
    private Socket socket;

    public java_11711_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the input and output streams from the socket
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a welcome message back to the client
            out.println("Welcome to the server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}