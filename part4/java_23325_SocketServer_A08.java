import java.io.*;
import java.net.*;
import java.util.*;

public class java_23325_SocketServer_A08 {
    private static final int PORT = 1234;
    private static final String AUTH_USER = "user";
    private static final String AUTH_PASS = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            authenticateClient(in, out, socket);

            if (clientAuthenticated) {
                if (checkIntegrity(clientMessage)) {
                    out.writeUTF("Message received successfully.");
                } else {
                    out.writeUTF("Integrity check failed.");
                }
            } else {
                out.writeUTF("Authentication failed.");
            }

            socket.close();
        }
    }

    private static boolean clientAuthenticated = false;
    private static boolean clientAuthenticated(String user, String pass, DataInputStream in, DataOutputStream out, Socket socket) throws IOException {
        String clientUser = in.readUTF();
        String clientPass = in.readUTF();

        clientAuthenticated = user.equals(clientUser) && pass.equals(clientPass);

        if (clientAuthenticated) {
            out.writeUTF("Authentication successful.");
        } else {
            out.writeUTF("Invalid user or password.");
        }

        return clientAuthenticated;
    }

    private static boolean checkIntegrity(String message) {
        // Here we can use a hash function to check the integrity of the message
        // In this example, we just assume all messages are identical
        return message.equals("A08_IntegrityFailure");
    }
}