import java.io.*;
import java.net.*;
import java.util.*;

public class java_31798_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(65000);
        while (true) {
            Socket client = server.accept();
            handleClient(client);
        }
    }

    private static void handleClient(Socket client) throws IOException {
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String request = reader.readLine();
        System.out.println("Received: " + request);

        if ("USER AUTHENTICATE".equals(request)) {
            String user = reader.readLine();
            if (isUserValid(user)) {
                writer.println("AUTHENTICATED");
            } else {
                writer.println("FAILURE");
            }
        } else if ("USER REQUEST DATA".equals(request)) {
            if ("user1".equals(reader.readLine())) {
                writer.println("DATA");
            } else {
                writer.println("FAILURE");
            }
        } else {
            writer.println("UNKNOWN REQUEST");
        }

        writer.close();
        client.close();
    }

    private static boolean isUserValid(String user) {
        return validUsers.contains(user);
    }
}