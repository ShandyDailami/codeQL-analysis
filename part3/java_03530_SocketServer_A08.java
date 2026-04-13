import java.io.*;
import java.net.*;

public class java_03530_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected");

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String request = in.readUTF();
                    System.out.println("Received request: " + request);

                    // For now, let's just simulate an integrity failure
                    // You should handle this in a real-world scenario.
                    if (request.contains("A08_IntegrityFailure")) {
                        throw new IOException("Integrity Failure");
                    }

                    out.writeUTF("Success");
                    System.out.println("Successfully processed request");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}