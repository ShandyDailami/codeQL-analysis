import java.io.*;
import java.net.*;

public class java_07034_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive the client's username and password
                String username = in.readUTF();
                String password = in.readUTF();
                System.out.println("Received username: " + username);
                System.out.println("Received password: " + password);

                // Check if the username and password are valid
                if ("test".equals(username) && "password".equals(password)) {
                    System.out.println("Authorized user: " + username);
                    out.writeUTF("Successfully logged in");
                } else {
                    out.writeUTF("Failed to log in");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}