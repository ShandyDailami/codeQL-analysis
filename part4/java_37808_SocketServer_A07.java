import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.Base64;

public class java_37808_SocketServer_A07 {
    private static final String PASSWORD = "5ba5e154deadbeef";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientPassword = in.readUTF();

            if (authenticate(clientPassword)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
                continue;
            }

            out.writeUTF("Message received: " + in.readUTF());
            socket.close();
        }
    }

    private static boolean authenticate(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String hashedPassword = Base64.getEncoder().encodeToString(md.digest(password.getBytes()));

        return hashedPassword.equals(PASSWORD);
    }
}