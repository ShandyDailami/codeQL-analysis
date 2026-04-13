import java.io.*;
import java.net.*;
import javax.security.auth.*;

public class java_38366_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started!");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                String password = in.readUTF();

                // Check if the credentials are valid (for the sake of simplicity, we assume they are correct)
                if (checkCredentials(username, password)) {
                    out.writeUTF("Successfully connected!");
                } else {
                    out.writeUTF("Failed to connect!");
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simple function to check if the username and password match
    private static boolean checkCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}