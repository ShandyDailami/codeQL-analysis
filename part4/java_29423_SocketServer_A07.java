import java.io.*;
import java.net.*;
import java.util.*;

public class java_29423_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress() + " connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            String[] clientDetails = clientMsg.split(" ");

            if (authenticateClient(clientDetails[0], clientDetails[1])) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}