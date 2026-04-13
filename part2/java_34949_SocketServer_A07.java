import java.io.*;
import java.net.*;

public class java_34949_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // Simulating authentication failure
            if (!validateUser(username, password)) {
                out.writeUTF("Authentication failed");
                out.flush();
            } else {
                out.writeUTF("Authentication successful");
                out.flush();
            }

            socket.close();
        }
    }

    private static boolean validateUser(String username, String password) {
        // Simulates a database lookup for username and password
        return username.equals("user") && password.equals("pass");
    }
}