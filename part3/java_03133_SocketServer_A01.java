import java.io.*;
import java.net.*;
import java.util.*;

public class java_03133_SocketServer_A01 {
    private static int DEFAULT_PORT = 1234;
    private static ServerSocket server;
    private static Socket client;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    public static void main(String[] args) {
        try {
            // Initialize the server socket
            server = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server is listening on port " + DEFAULT_PORT);

            while (true) {
                // Wait for a client to connect
                client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Initialize the input and output streams
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                // Read a message from the client
                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                // Send a message back to the client
                String response = "Server received your message: " + message;
                dos.writeUTF(response);
                System.out.println("Sent response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (client != null) client.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}