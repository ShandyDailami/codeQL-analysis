import java.io.*;
import java.net.*;
import java.util.*;

public class java_10637_SocketServer_A07 {

    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String receivedUserName = null;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Please enter your username");

            String userName = in.readLine();

            if (isValidUser(userName)) {
                out.println("Authentication successful");
                out.flush();
            } else {
                out.println("Authentication failed");
                out.flush();
                socket.close();
                continue;
            }

            receivedUserName = userName;
            out.println("Hello, " + userName + ". You are connected.");
            out.flush();

            // Echo back received messages
            String response;
            do {
                response = in.readLine();
                out.println("Received: " + response);
            } while (!response.equals("exit"));

            out.close();
            socket.close();
        }
    }

    private static boolean isValidUser(String userName) {
        return validUsers.contains(userName);
    }
}