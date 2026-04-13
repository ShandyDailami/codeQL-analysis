import java.io.*;
import java.net.*;

public class java_19161_SocketServer_A01 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Read password from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String received = in.readUTF();

            if (received.equals(PASSWORD)) {
                // Send response to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Access granted");
            } else {
                // If the password is incorrect, send a message to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Access denied");
            }

            socket.close();
        }
    }
}