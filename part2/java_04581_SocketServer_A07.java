import java.io.*;
import java.net.*;
import java.util.*;

public class java_04581_SocketServer_A07 {
    private static ArrayList<String> validUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));
    private static String serverMessage = "Server ready...";

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(6789);
            System.out.println("Waiting for client connection...");

            // Accept a client
            socket = server.accept();
            System.out.println("Connected to client");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send server message
            dos.writeUTF(serverMessage);

            // Read client message
            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            // Authenticate the user
            String clientUser = clientMessage.split(" ")[1];
            if (isValidUser(clientUser)) {
                dos.writeUTF("Authentication successful");
            } else {
                dos.writeUTF("Authentication failed");
            }

            // Close streams and socket
            dos.close();
            dis.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check if the user is valid
    private static boolean isValidUser(String user) {
        return validUsers.contains(user);
    }
}