import java.io.*;
import java.net.*;
import java.util.*;

public class java_16942_SocketServer_A07 {
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);
                if (authenticate(clientMsg)) {
                    out.writeUTF("Authenticated successfully");
                } else {
                    out.writeUTF("Authentication failed");
                }
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean authenticate(String clientMsg) {
        String[] parts = clientMsg.split(":");
        if (parts.length != 2) {
            return false;
        }
        String username = parts[0];
        String password = parts[1];
        return password.equals(PASSWORD) && !username.isEmpty();
    }
}