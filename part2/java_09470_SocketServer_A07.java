import java.io.*;
import java.net.*;

public class java_09470_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Start of authentication code
                String username = in.readUTF();
                String password = in.readUTF();

                if (isValidUser(username, password)) {
                    out.writeUTF("Connection established");
                } else {
                    out.writeUTF("Invalid username or password");
                    out.close();
                    client.close();
                    continue;
                }

                out.writeUTF("Connection established");
                out.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidUser(String username, String password) {
        // Implement authentication logic here using security-sensitive operations
        // For simplicity, we'll just check if the username is "admin" and the password is "password"
        return username.equals("admin") && password.equals("password");
    }
}