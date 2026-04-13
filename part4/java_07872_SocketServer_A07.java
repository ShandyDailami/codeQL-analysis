import java.io.*;
import java.net.*;
import java.util.*;

public class java_07872_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "authenticated_user";
    private static List<String> authorizedUsers = Arrays.asList("user1", "user2", AUTHENTICATED_USER);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started at port 8189");
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String user = in.readUTF();
                    if (!isUserAuthorized(user)) {
                        out.writeUTF("Authentication failed");
                        out.flush();
                        socket.close();
                    } else {
                        out.writeUTF("Authentication successful");
                        out.flush();
                        handleClient(socket, in, out);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean isUserAuthorized(String user) {
        return authorizedUsers.contains(user);
    }

    private static void handleClient(Socket socket, DataInputStream in, DataOutputStream out) throws IOException {
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        // Assume that the server will send a response with the request
        String response = "Response for " + request;
        out.writeUTF(response);
        out.flush();

        socket.close();
    }
}