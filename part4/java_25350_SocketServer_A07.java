import java.io.*;
import java.net.*;
import java.util.*;

public class java_25350_SocketServer_A07 {

    private static List<String> authorizedUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        String userName = input.readUTF();
        if (isUserAuthorized(userName)) {
            output.writeUTF("Welcome " + userName);
        } else {
            output.writeUTF("Unauthorized");
        }

        clientSocket.close();
    }

    private static boolean isUserAuthorized(String userName) {
        return authorizedUsers.contains(userName);
    }
}