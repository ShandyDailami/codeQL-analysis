import java.io.*;
import java.net.*;
import java.util.*;

public class java_30122_SocketServer_A07 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            System.out.println("Waiting for connections...");
            while (true) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client accepted");
                out = new DataOutputStream(client.getOutputStream());
                in = new DataInputStream(client.getInputStream());
                String username = in.readUTF();
                if (validateUser(username)) {
                    System.out.println("User " + username + " authenticated");
                    out.writeUTF("User " + username + " authenticated");
                } else {
                    System.out.println("User " + username + " failed to authenticate");
                    out.writeUTF("User " + username + " failed to authenticate");
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean validateUser(String username) {
        // Here you can add the logic to authenticate the user.
        // This is a simple example where we assume the user is valid if it starts with "A"
        return username.startsWith("A");
    }
}