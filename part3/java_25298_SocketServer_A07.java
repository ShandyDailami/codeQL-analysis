import java.io.*;
import java.net.*;
import java.util.*;

public class java_25298_SocketServer_A07 {
    private static final int port = 12345;
    private static Set<Socket> connectedClients = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                connectedClients.add(client);
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {
        new Thread(() -> {
            try {
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read username from client
                String username = in.readUTF();

                // Send auth response to client
                out.writeUTF("AuthSuccess: " + username);
                out.flush();

                // Close connection
                client.close();
                connectedClients.remove(client);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}