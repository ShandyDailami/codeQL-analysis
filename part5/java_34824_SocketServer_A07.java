import java.io.*;
import java.net.*;

public class java_34824_SocketServer_A07 {
    private static String USERNAME = "user";
    private static String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Read and handle the authentication request
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String receivedUsername = in.readUTF();
            String receivedPassword = in.readUTF();

            if (receivedUsername.equals(USERNAME) && receivedPassword.equals(PASSWORD)) {
                out.writeUTF("Authenticated");
            } else {
                out.writeUTF("Authentication failed");
           .
.
.
.
out.writeUTF("successful_authentication");
            }

            socket.close();
        }
    }
}