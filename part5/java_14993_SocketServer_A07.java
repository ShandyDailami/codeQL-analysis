import java.io.*;
import java.net.*;

public class java_14993_SocketServer_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                out.writeUTF("Authentication successful. Welcome " + username);
            } else {
                out.writeUTF("Authentication failed.");
                socket.close();
            }
        }
    }
}