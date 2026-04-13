import java.io.*;
import java.net.*;
import java.util.*;

public class java_40042_SocketServer_A08 {

    private static final String AUTH_USER = "user";
    private static final String AUTH_PASS = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started with port " + server.getLocalPort());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (authenticate(in, out)) {
                out.writeUTF("Thank you for connecting");
            } else {
                out.writeUTF("Authentication failed. Please try again.");
            }

            socket.close();
        }
    }

    private static boolean authenticate(DataInputStream in, DataOutputStream out) throws IOException {
        String user = in.readUTF();
        String pass = in.readUTF();

        return AUTH_USER.equals(user) && AUTH_PASS.equals(pass);
    }
}