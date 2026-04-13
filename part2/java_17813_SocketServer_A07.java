import java.io.*;
import java.net.*;
import java.util.*;

public class java_17813_SocketServer_A07 {
    private static final String PASSWORD = "securePassword";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientPassword = input.readUTF();

            if (clientPassword.equals(PASSWORD)) {
                output.writeUTF("Authentication successful");
            } else {
                output.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }
}