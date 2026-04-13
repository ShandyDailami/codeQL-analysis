import java.io.*;
import java.net.*;
import java.util.*;

public class java_05338_SocketServer_A01 {
    private static final String PASSWORD = "secret";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientPassword = in.readUTF();

            if (authenticate(clientPassword)) {
                System.out.println("Authentication successful");
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication successful");
            } else {
                System.out.println("Authentication failed");
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String password) {
        return password.equals(PASSWORD);
    }
}