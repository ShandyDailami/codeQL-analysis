import java.io.*;
import java.net.*;

public class java_07442_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // The following line is a placeholder for injection prevention.
            // The actual operation would be more complex, involving checking for SQL injection,
            // command injection, or other types of attack.
            String response = "Server received: " + message;

            out.writeUTF(response);
            out.flush();
            client.close();
        }
    }
}