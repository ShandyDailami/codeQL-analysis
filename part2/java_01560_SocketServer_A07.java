import java.io.*;
import java.net.*;
import java.util.*;

public class java_01560_SocketServer_A07 {

    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String user = in.readUTF();

                    if (isUserValid(user)) {
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF("Auth successful: " + user);
                    } else {
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF("Auth failure");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUserValid(String user) {
        return validUsers.contains(user);
    }
}