import java.io.*;
import java.net.*;
import java.util.*;

public class java_38072_SocketServer_A07 {

    private static final String PASSWORD = "securepassword";
    private static final String CORRECT_PASSWORD = "correctpassword";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientPassword = in.readUTF();

            if (clientPassword.equals(PASSWORD)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            socket.close();
        }
    }
}