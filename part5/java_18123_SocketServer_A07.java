import java.io.*;
import java.net.*;
import java.util.*;

public class java_18123_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private static final int PORT = 1234;
    private static Set<String> authorizedClients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if (isAuthorized(request)) {
                out.writeUTF("Request accepted");
            } else {
                out.writeUTF(AUTH_FAILURE);
            }

            out.close();
            socket.close();
        }
    }

    private static boolean isAuthorized(String request) {
        // Here we simulate the authentication process by comparing the request with a hard-coded username.
        // In a real application, you would typically use a more secure method for authentication.
        return "username".equals(request);
    }
}