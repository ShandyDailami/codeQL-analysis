import java.net.*;
import java.io.*;
import java.util.*;

public class java_39196_SocketServer_A08 {

    private static final String MESSAGE = "Hello, client!";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {

            Socket client = server.accept();
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(MESSAGE);

            DataInputStream in = new DataInputStream(client.getInputStream());
            String receivedMessage = in.readUTF();
            System.out.println("Received message from client: " + receivedMessage);

            client.close();
        }
    }
}