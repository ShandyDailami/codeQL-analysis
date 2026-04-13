import java.io.*;
import java.net.*;

public class java_23310_SocketServer_A07 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Perform some security-sensitive operation here
            // For example, validate the username and password
            if (validateUser(message)) {
                dos.writeUTF("Success!");
            } else {
                dos.writeUTF("Failed!");
            }

            dos.close();
            socket.close();
        }
    }

    private static boolean validateUser(String user) {
        // Implement a secure way of validating user here
        // For example, you can use a hash of the user's password
        // To make this example work, we need a password hash
        // You can use a library such as bcrypt or Argon2 for hashing
        // This is a simplified example and does not actually hash the password

        return true;
    }

}