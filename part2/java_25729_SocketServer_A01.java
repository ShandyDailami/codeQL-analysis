import java.io.*;
import java.net.*;
import java.util.*;

public class java_25729_SocketServer_A01 {

    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASS = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client accepted: " + client.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMsg = in.readLine();
            System.out.println("Client says: " + clientMsg);

            if (authenticate(clientMsg)) {
                out.println("Welcome!");
            } else {
                out.println("Access denied.");
            }

            client.close();
        }
    }

    private static boolean authenticate(String clientMsg) {
        String[] parts = clientMsg.split(" ");
        return parts.length == 2 && AUTH_USER.equals(parts[0]) && AUTH_PASS.equals(parts[1]);
    }
}