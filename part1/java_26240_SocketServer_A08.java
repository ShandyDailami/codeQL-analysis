import java.io.*;
import java.net.*;

public class java_26240_SocketServer_A08 {
    private static final String REMOTE_HOST = "localhost";
    private static final int REMOTE_PORT = 6666;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(REMOTE_PORT);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Add a password for authentication
            String password = "password";
            if (authenticate(in, out, password)) {
                handleClient(in, out);
            } else {
                System.out.println("Authentication failed, closing connection");
                out.close();
                in.close();
                socket.close();
            }
        }
    }

    private static boolean authenticate(DataInputStream in, DataOutputStream out, String password) throws IOException {
        String clientPassword = in.readUTF();
        return password.equals(clientPassword);
    }

    private static void handleClient(DataInputStream in, DataOutputStream out) throws IOException {
        String message = in.readUTF();
        out.writeUTF("Server: " + message);
        out.flush();
    }
}