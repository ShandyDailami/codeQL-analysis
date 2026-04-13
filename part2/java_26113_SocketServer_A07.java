import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26113_SocketServer_A07 {

    private ServerSocket server;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public java_26113_SocketServer_A07(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String username = input.readUTF();
            String password = input.readUTF();
            String hashedPassword = hashPassword(password);

            if (username.equals("admin") && hashedPassword.equals("$2a$10$/EBYbqJG9fq40ZMZ.9vR5.qkZH79HwRD898dvNq3WPfM3F/Qi2")) { // Hardcoded for testing
                output.writeUTF("Access Granted");
            } else {
                output.writeUTF("Access Denied");
            }

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new SocketServer(5000);
    }
}