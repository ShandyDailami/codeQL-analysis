import java.io.*;
import java.net.*;

public class java_08002_SocketServer_A07 {
    private static final int PORT = 4445;
    private static boolean isStopped = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (!isStopped) {
            Socket socket = serverSocket.accept();

            // Handle client connection
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            // Perform authentication
            if (authenticate(socket)) {
                handleRequests(socket);
            } else {
                closeSocket(socket);
            }
        }

        serverSocket.close();
    }

    private static boolean authenticate(Socket socket) throws IOException {
        // Simulate authentication process by accepting a username
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Enter username:");
        String username = in.readUTF();

        // Check if username is valid (this is a dummy operation)
        if (isValidUsername(username)) {
            out.writeUTF("Authenticated successfully");
            out.flush();
            return true;
        } else {
            out.writeUTF("Authentication failed");
            out.flush();
            return false;
        }
    }

    private static void handleRequests(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Simulate request handling
        while (true) {
            System.out.println("Waiting for request...");
            String request = in.readUTF();

            if (request.equals("END")) {
                break;
            }

            out.writeUTF("Received: " + request);
            out.flush();
        }

        closeSocket(socket);
    }

    private static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidUsername(String username) {
        // This is a simple check for validity, in a real-world scenario, you should use a more secure mechanism
        return username != null && !username.isEmpty();
    }
}