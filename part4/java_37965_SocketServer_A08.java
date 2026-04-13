import java.io.*;
import java.net.*;
import java.util.*;

public class java_37965_SocketServer_A08 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port: " + SERVER_PORT);

            // Accept a client socket
            socket = server.accept();
            System.out.println("Connected to client: " + socket.getInetAddress().getHostAddress());

            // Create data streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Handle client's request
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Respond to client
            String response = "Server's response to client's request: " + request;
            dos.writeUTF(response);

            // Close data streams and socket
            dos.close();
            dis.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}