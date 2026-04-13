import java.io.*;
import java.net.*;

public class java_37228_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final String LOCAL_HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT, 1000, InetAddress.getByName(LOCAL_HOST))) {
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("New client connected from " + client.getRemoteSocketAddress());

                    DataInputStream in = new DataInputStream(client.getInputStream());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());

                    // Perform basic security measures related to A01_BrokenAccessControl
                    // ...

                    String message = in.readUTF();
                    System.out.println("Client says: " + message);

                    // Echo back to client
                    out.writeUTF(message);
                    out.flush();
                }
            }
        }
    }
}