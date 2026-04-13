import java.io.*;
import java.net.*;
import java.util.*;

public class java_38997_SocketServer_A07 {
    private static final int port = 1234;
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                socket = server.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Authentication
                String userName = in.readUTF();
                if (!validateUser(userName)) {
                    out.writeUTF("AuthFailure");
                    out.close();
                    socket.close();
                    continue;
                }

                // Receive message from client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send message back to client
                out.writeUTF("Success: Received your message");
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateUser(String userName) {
        // Implement user validation here. For this example, we assume all users are valid.
        return true;
    }
}