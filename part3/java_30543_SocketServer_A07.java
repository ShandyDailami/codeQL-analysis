import java.io.*;
import java.net.*;
import java.util.*;

public class java_30543_SocketServer_A07 {
    private static final String PASSWORD = "secure";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server is listening on port 8189...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                String username = in.readUTF();
                String password = in.readUTF();

                if (authenticate(username, password)) {
                    out.writeUTF("Authentication successful!");
                } else {
                    out.writeUTF("Authentication failed!");
                }

                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return PASSWORD.equals(username) && PASSWORD.equals(password);
    }
}