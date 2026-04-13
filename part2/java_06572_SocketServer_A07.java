import java.io.*;
import java.net.*;
import java.util.*;

public class java_06572_SocketServer_A07 {
    private static final String SERVER_STATUS = "Server listening on port: ";
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;
    private static int port = 6000;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());
                clients.add(client);
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (Socket client : clients) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server.close();
        }
    }

    private static void handleClient(Socket client) {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Send server status
            out.writeUTF(SERVER_STATUS + client.getLocalPort());

            // Receive client's request
            String request = in.readUTF();
            System.out.println("Client says: " + request);

            // Send back the response
            out.writeUTF("Thank you for connecting to port " + client.getLocalPort() + ", your message was: " + request);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}