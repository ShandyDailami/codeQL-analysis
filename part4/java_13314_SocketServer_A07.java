import java.io.*;
import java.net.*;

public class java_13314_SocketServer_A07 {
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failed. Access denied.";

    public static void main(String[] args) {
        int port = 12345; // Change this to the port you want to use.

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String authResponse = authenticateClient(socket);
                out.writeUTF(authResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String authenticateClient(Socket socket) {
        try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
            String clientId = in.readUTF();

            // This is a simplistic authentication check. In real-world applications, 
            // you would typically use a more secure method of authentication.
            if (clientId.equals("12345")) {
                return AUTH_FAILURE_MESSAGE;
            }

            return "Authentication successful.";
        } catch (IOException e) {
            return "Failed to authenticate client.";
        }
    }
}