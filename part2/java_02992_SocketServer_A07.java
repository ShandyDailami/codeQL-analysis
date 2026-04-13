import java.net.*;
import java.io.*;

public class java_02992_SocketServer_A07 {
    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started. Listening on port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the username from the client
                String username = in.readUTF();
                System.out.println("Received username: " + username);

                // Authenticate the user
                if (authenticateUser(username)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
               
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateUser(String username) {
        // TODO: Implement authentication logic here.
        // This is a placeholder and should be replaced with actual authentication logic.
        // For now, we'll just simulate a successful authentication.
        return true;
    }
}