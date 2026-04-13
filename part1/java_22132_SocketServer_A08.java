import java.io.*;
import java.net.*;

public class java_22132_SocketServer_A08 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();

            // Create streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Handle each request
            handleRequest(in, out);

            // Close connections
            out.close();
            in.close();
            socket.close();
        }
    }

    private static void handleRequest(DataInputStream in, DataOutputStream out) throws IOException {
        // Read request
        String request = in.readUTF();

        // Check for integrity failure
        if (request.equals("A08_IntegrityFailure")) {
            // Write response
            out.writeUTF("Error: IntegrityFailure");
        } else {
            // Write response
            out.writeUTF("Success: " + request);
        }
    }
}