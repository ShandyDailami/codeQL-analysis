import java.io.*;
import java.net.*;
import java.util.*;

public class java_31860_SocketServer_A07 {

    // hardcoded data
    private static String[] hardcodedData = {"user1", "password1", "user2", "password2"};

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6789);
        while (true) {
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = reader.readLine();
            String[] request = clientMessage.split(":");

            // check authentication
            if (authenticate(request[0], request[1])) {
                writer.println("Authentication successful!");
            } else {
                writer.println("Authentication failed!");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        for (String[] data : hardcodedData) {
            if (data[0].equals(username) && data[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}