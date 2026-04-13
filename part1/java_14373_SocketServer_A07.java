import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_14373_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Security sensitive operation: Authentication
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(message.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                String authenticationCode = sb.toString();

                System.out.println("Authentication code: " + authenticationCode);

                dos.writeUTF(authenticationCode);
                dos.flush();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}