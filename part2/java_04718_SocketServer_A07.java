import java.io.*;
import java.net.*;
import java.util.*;

public class java_04718_SocketServer_A07 {
    private static final String SERVER_MESSAGE = "Welcome to the server!";
    private static final String CLIENT_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on " + CLIENT_ADDRESS + " port " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(SERVER_MESSAGE);

                DataInputStream in = new DataInputStream(client.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                if (authenticateClient(clientMessage)) {
                    out.writeUTF("Authentication successful!");
                } else {
                    out.writeUTF("Authentication failed!");
                }

                client.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticateClient(String message) {
        // Simple authentication: if the message is "Hello" return true, else false
        return message.equals("Hello");
    }
}