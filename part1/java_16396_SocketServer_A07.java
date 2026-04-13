import java.io.*;
import java.net.*;
import java.util.*;

public class java_16396_SocketServer_A07 {
    private static final String SERVER_SOFTWARE = "SecureSocketServer/1.0";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                if (isAuthorized(request)) {
                    out.writeUTF("Authorized");
                } else {
                    out.writeUTF("Unauthorized");
                }

                out.close();
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean isAuthorized(String request) {
        // This is a simple example of authentication and authorization.
        // In a real application, you would typically use a more complex method to authenticate users and check their permissions.
        // Also, this example does not use any encryption, but a real-world application would use encryption to prevent eavesdropping.

        // In this example, we'll just check if the request contains a specific word.
        // You should use a more secure method to authenticate users and check their permissions.
        return request.toLowerCase().contains("admin");
    }
}