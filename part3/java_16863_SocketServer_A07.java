import java.io.*;
import java.net.*;
import java.util.*;

public class java_16863_SocketServer_A07 {
    private static final String AUTH_KEY = "A07_AuthKey"; // hardcoded key for demonstration
    private static final int AUTH_PORT = 12345;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                if (authenticateClient(client)) {
                    out.writeUTF("Authentication successful, sending back response...");
                    out.flush();

                    String responseMessage = "Hello, " + clientMessage + "!";
                    out.writeUTF(responseMessage);
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed, sending back error message...");
                    out.flush();

                    String responseMessage = "Authentication failed. Please try again.";
                    out.writeUTF(responseMessage);
                    out.flush();
                }

                out.close();
                in.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (client != null) client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean authenticateClient(Socket client) {
        // For demonstration purposes, we will use a static key
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            String key = in.readUTF();

            if (key.equals(AUTH_KEY)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}