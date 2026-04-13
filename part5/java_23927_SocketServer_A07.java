import java.io.*;
import java.net.*;
import java.util.*;

public class java_23927_SocketServer_A07 {
    private static ArrayList<String> authorizedUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is running...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(socket);
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

    private static void handleClient(Socket socket) {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            if (isAuthorized(clientMessage)) {
                output.writeUTF("Access granted");
            } else {
                output.writeUTF("Access denied");
            }

            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAuthorized(String username) {
        return authorizedUsers.contains(username);
    }
}