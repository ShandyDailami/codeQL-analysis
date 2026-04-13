import java.io.*;
import java.net.*;
import java.util.*;

public class java_18819_SocketServer_A07 {
    private static final int port = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Perform authentication
            if (authenticate(socket)) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                dos.writeUTF("Successfully authenticated");
                dos.flush();
            } else {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("Authentication failed");
                dos.flush();
            }

            socket.close();
        }
    }

    private static boolean authenticate(Socket socket) throws IOException {
        // Here you could use a library like bcrypt or a hardcoded string to hash the passwords.
        // However, in this case, we'll just use a hardcoded string for simplicity.
        return "password".equals(hash("password", socket.getInputStream()));
    }

    private static String hash(String password, InputStream rawInput) throws IOException {
        // This is a very simple hash function for demonstration purposes. In a real application,
        // you'd likely use a library or function that has been tested thoroughly.
        try (InputStream inputStream = new DigestInputStream(rawInput, DigestAlgorithm.SHA1.newDigest())) {
            byte[] buffer = new byte[8192];
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                DigestAlgorithm.SHA1.update(buffer, 0, bytesNumRead);
            }
            return new String(DigestAlgorithm.SHA1.digest());
        }
    }
}