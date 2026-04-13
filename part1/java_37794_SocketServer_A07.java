import java.io.*;
import java.net.*;
import java.util.*;

public class java_37794_SocketServer_A07 {
    private static final int PORT = 8888;
    private static boolean closed = false;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while(!closed) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Start a new thread for each connection
                new HandleConnection(socket).start();
            }

            serverSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleConnection extends Thread {
    private final Socket socket;

    public java_37794_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the client's request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Simulate a security-sensitive operation related to authentication
            if (!"auth".equals(request)) {
                out.writeBytes("Invalid request\n");
                return;
            }

            // Generate a random username for the client
            String username = UUID.randomUUID().toString();
            out.writeBytes("Authenticated as " + username + "\n");

            // Start a new thread for each conversation with the client
            new HandleConversation(socket, username).start();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleConversation extends Thread {
    private final Socket socket;
    private final String username;

    public java_37794_SocketServer_A07(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            out.writeBytes("Welcome, " + username + "\n");

            // Send a message to all other clients
            out.writeBytes("Greetings to all, " + username + "\n");

            // Send a message to a specific client
            out.writeBytes("Hello " + username + "\n");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}