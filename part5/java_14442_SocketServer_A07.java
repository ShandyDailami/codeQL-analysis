import java.io.*;
import java.net.*;
import java.util.*;

public class java_14442_SocketServer_A07 {
    private static final String AUTHENTICATED_USERS = "authenticated_users";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected at " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientName = in.readUTF();
            if (authenticateUser(clientName)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
                socket.close();
                continue;
            }

            while (true) {
                String message = in.readUTF();
                if ("exit".equals(message)) {
                    break;
                }
                System.out.println("Received message from client: " + message);
                out.writeUTF("Message received");
           
            }
            socket.close();
        }
    }

    private static boolean authenticateUser(String clientName) throws IOException {
        // Simulate a simple authentication mechanism by checking against a hardcoded list
        List<String> authenticatedUsers = new ArrayList<>(Arrays.asList(AUTHENTICATED_USERS.split(",")));
        return authenticatedUsers.contains(clientName);
    }
}