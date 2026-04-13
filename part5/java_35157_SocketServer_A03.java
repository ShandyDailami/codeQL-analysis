import java.io.*;
import java.net.*;
import java.util.*;

public class java_35157_SocketServer_A03 {
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is running on port: " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
        }
    }
}