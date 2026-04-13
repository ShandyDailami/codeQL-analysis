import java.io.*;
import java.net.*;

public class java_12943_SocketServer_A01 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            server = new ServerSocket(12345);
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client connected");

            // Read the username from the socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            // Authenticate the client
            if ("admin".equals(clientMsg)) {
                // Send welcome message
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Welcome, admin!");
            } else {
                // Send error message
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Error, wrong password!");
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}