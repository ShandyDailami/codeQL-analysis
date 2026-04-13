import java.io.*;
import java.net.*;

public class java_15627_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 1: Authentication
            // This is a simplistic example and doesn't cover all possible authentication methods
            String username = in.readUTF();
            String password = in.readUTF();

            if (!authenticate(username, password)) {
                out.writeUTF("A07_AuthFailure");
                out.flush();
                socket.close();
                continue;
            }

            // Step 2: Communication
            String message = in.readUTF();
            out.writeUTF("Server received: " + message);
            out.flush();

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        // This is a simplistic example and doesn't cover actual security measures
        // You would want to use secure ways to compare passwords, use encryption, etc.
        return username.equals("admin") && password.equals("password");
    }
}