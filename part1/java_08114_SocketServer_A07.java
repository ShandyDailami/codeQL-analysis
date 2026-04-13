import java.io.*;
import java.net.*;

public class java_08114_SocketServer_A07 {

    private static final int PORT = 1234;
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (running) {
            Socket client = server.accept();
            System.out.println("Connected: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Simulate a request to authenticate the client
            String response = authenticateClient(request);

            out.writeUTF(response);
            out.flush();
        }

        server.close();
    }

    private static String authenticateClient(String request) {
        // Remove the comment for testing
        // TODO: Implement authentication logic

        // For now, let's return a simple message
        return "Client authenticated";
    }
}