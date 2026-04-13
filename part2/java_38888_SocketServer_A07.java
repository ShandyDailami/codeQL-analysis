import java.io.*;
import java.net.*;
import java.util.*;

public class java_38888_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static boolean isAuthenticated = false;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at " + new Date());

        while (!isShutdown) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            // Verify the client identity
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                isAuthenticated = true;
            } else {
                out.writeUTF("Error: Invalid username or password");
                out.close();
                socket.close();
                continue;
            }

            // If the client is authenticated, then proceed with communication
            if (isAuthenticated) {
                out.writeUTF("Successfully authenticated!");
                out.close();
            } else {
                out.writeUTF("Error: Authentication failed");
                out.close();
                socket.close();
                continue;
            }
        }

        server.close();
    }
}