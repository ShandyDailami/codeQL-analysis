import java.io.*;
import java.net.*;

public class java_34999_SocketServer_A03 {
    private static final String SERVER_NAME = "ChatServer";
    private static final int SERVER_PORT = 12345;
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static DataInputStream input;
    private static DataOutputStream output;
    private static String clientName;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Waiting for client on port " + SERVER_PORT + "...");
            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            // Request client's username
            output.writeUTF("USERNAME");
            clientName = input.readUTF();
            System.out.println("Username is: " + clientName);

            // Request client's password
            output.writeUTF("PASSWORD");
            String password = input.readUTF();
            System.out.println("Password is: " + password);

            // Send welcome message
            output.writeUTF("WELCOME " + clientName + "!");

            // Start receiving and sending messages
            while (true) {
                String message = input.readUTF();
                System.out.println(clientName + ": " + message);
                output.writeUTF("RECEIVED: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}