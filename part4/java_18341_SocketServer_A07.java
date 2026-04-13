import java.io.*;
import java.net.*;

public class java_18341_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234); // listen on port 1234
        while (true) {
            Socket socket = server.accept(); // wait for a client to connect
            System.out.println("Client connected!");

            // Create streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Check for authentication
            boolean authFailed = false;
            String username = in.readUTF(); // read username
            String password = in.readUTF(); // read password
            if (!username.equals("admin") || !password.equals("password")) {
                authFailed = true;
            }

            if (authFailed) {
                out.writeUTF("A07_AuthFailure"); // if authentication failed, send auth failure message
            } else {
                out.writeUTF("A07_AuthSuccess"); // if authentication succeeded, send success message
           
                // Now, we can safely read from the input stream
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Client says: " + message);
                }
            }

            socket.close();
        }
    }
}