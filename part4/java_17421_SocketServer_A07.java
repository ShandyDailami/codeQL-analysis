import java.io.*;
import java.net.*;
import java.util.*;

public class java_17421_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_17421_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the client's name
            String clientName = input.readUTF();
            System.out.println(clientName + " connected");

            // Perform the authentication
            if (authenticate(clientName)) {
                // Send a welcome message to the client
                output.writeUTF("Welcome, " + clientName + "!");
            } else {
                // Send an error message if authentication fails
                output.writeUTF("Failed to authenticate");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String clientName) {
        // Simulate authentication by checking if the client name is "admin"
        return "admin".equals(clientName);
    }
}