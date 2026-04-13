import java.io.*;
import java.net.*;
import java.util.*;

public class java_06525_SocketServer_A07 {

    private static final int PORT = 9876;
    private static final String AUTHENTICATED_USER = "authenticated_user";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected. Authenticating...");

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String clientUsername = in.readUTF();

        if (clientUsername.equals(AUTHENTICATED_USER)) {
            System.out.println("Authenticated user.");
            out.writeUTF("Connection successful");
        } else {
            System.out.println("Failed to authenticate user.");
            out.writeUTF("Connection failed");
        }

        socket.close();
    }
}