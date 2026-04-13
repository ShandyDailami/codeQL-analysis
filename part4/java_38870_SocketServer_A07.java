import java.io.*;
import java.net.*;
import java.util.*;

public class java_38870_SocketServer_A07 {
    public static List<String> authorizedUsers = Arrays.asList("user1", "user2", "admin");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client says: " + clientMsg);

            StringTokenizer st = new StringTokenizer(clientMsg);
            String user = st.nextToken();
            String pass = st.nextToken();

            if (isAuthorized(user, pass)) {
                dos.writeUTF("Authenticated");
            } else {
                dos.writeUTF("Authentication failed");
            }

            dos.close();
            socket.close();
        }
    }

    private static boolean isAuthorized(String user, String pass) {
        return authorizedUsers.contains(user) && authorizedUsers.contains(pass);
    }
}