import java.io.*;
import java.net.*;

public class java_11264_SocketServer_A08 {
    private static final String REMOTE_HOST = "localhost";
    private static final int REMOTE_PORT = 9876;
    private static final int TIMEOUT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(REMOTE_PORT);
            System.out.println("Server is listening on port " + REMOTE_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read the message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Check if the message is null or empty
                if (message == null || message.trim().isEmpty()) {
                    System.out.println("Invalid message received, closing connection");
                    client.close();
                    continue;
                }

                // Check if the message is a specific keyword
                if (message.equals("DDoS")) {
                    System.out.println("Detected DoS attack, closing connection");
                    client.close();
                    continue;
                }

                // Check if the message is a specific command
                if (message.equals("QUIT")) {
                    out.writeUTF("Connection closed");
                    client.close();
                    continue;
                }

                // Check if the message is a simple text message
                if (message.charAt(0) == '/') {
                    // Check if the message is a command
                    if (message.startsWith("/CHECK_INTEGRITY", 0)) {
                        String command = message.substring(12);

                        // Implement the command here (e.g., check the integrity of the command)
                        if (command.equals("FAILURE")) {
                            out.writeUTF("Integrity failure detected");
                        } else {
                            out.writeUTF("Command not recognized");
                        }

                        out.flush();
                        continue;
                    }

                    // Send a simple text message back to the client
                    out.writeUTF("Hello, client!");
                } else {
                    // Send a simple text message back to the client
                    out.writeUTF("Invalid message received, closing connection");
                }

                out.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}