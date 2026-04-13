import java.io.*;
import java.net.*;

public class java_01479_SocketServer_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (authenticateClient(clientUsername, clientPassword)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}