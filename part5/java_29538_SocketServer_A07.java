import java.io.*;
import java.net.*;
import java.util.*;

public class java_29538_SocketServer_A07 {
    private static String USERNAME = "username";
    private static String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected at " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authentication process
            if (!authenticate(in, out)) {
                System.out.println("Authentication failed. Closing connection.");
                out.close();
                in.close();
                socket.close();
                continue;
            }

            // Process request
            out.writeUTF("Hello client, you are authenticated.");
            out.close();
            in.close();
            socket.close();
        }
    }

    private static boolean authenticate(DataInputStream in, DataOutputStream out) throws IOException {
        String inputUsername = in.readUTF();
        String inputPassword = in.readUTF();

        if (!inputUsername.equals(USERNAME) || !inputPassword.equals(PASSWORD)) {
            out.writeUTF("Authentication failed. Wrong username or password.");
            out.flush();
            return false;
        }

        out.writeUTF("Authentication succeeded.");
        out.flush();
        return true;
    }
}