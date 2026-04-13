import java.net.*;
import java.io.*;

public class java_10340_SocketServer_A03 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           
            }

            socket.close();
        }
    }
}