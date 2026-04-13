import java.net.*;
import java.io.*;
import java.util.*;

public class java_12607_SocketServer_A01 {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));

        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            dos.writeUTF("Welcome to the server!");

            // Receive the message from the client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Close the connection
            socket.close();
        }
    }
}