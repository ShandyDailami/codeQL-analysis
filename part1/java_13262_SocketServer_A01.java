import java.io.*;
import java.net.*;

public class java_13262_SocketServer_A01 {
    private static int port = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        // Start server
        startServer(port);

        // Listen for connections
        while (true) {
            Socket socket = acceptConnection();
            if (socket != null) {
                handleConnection(socket);
            }
        }
    }

    private static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private static Socket acceptConnection() throws IOException {
        return serverSocket.accept();
    }

    private static void handleConnection(Socket socket) {
        try {
            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Hello, client!");

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}