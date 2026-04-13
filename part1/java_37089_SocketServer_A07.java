import java.io.*;
import java.net.*;

public class java_37089_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authenticate the client
            String username = in.readUTF();
            System.out.println("Username: " + username);
            if (!authenticate(username)) {
                out.writeUTF("FAILURE");
                out.flush();
                socket.close();
                continue;
            }

            // Send success message
            out.writeUTF("SUCCESS");
            out.flush();

            socket.close();
        }
    }

    private static boolean authenticate(String username) {
        // Add security-sensitive operations related to A07_AuthFailure here
        // For now, let's just return true
        return true;
    }
}