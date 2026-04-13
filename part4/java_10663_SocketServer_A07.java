import java.io.*;
import java.net.*;
import java.util.*;

public class java_10663_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            String[] clientDetails = clientMessage.split(" ");
            String clientUsername = clientDetails[0];
            String clientPassword = clientDetails[1];

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.writeUTF("Welcome " + clientUsername);
            } else {
                out.writeUTF("Access denied");
                socket.close();
                continue;
            }

            out.writeUTF("Access granted");

            socket.close();
        }
    }
}