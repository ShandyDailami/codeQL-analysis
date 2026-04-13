import java.io.*;
import java.net.*;
import java.util.*;

public class java_09002_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String USER_NAME = "user";
    private static String PASS_WORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client connection...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read username and password from client
            String clientInput = in.readLine();
            StringTokenizer st = new StringTokenizer(clientInput);
            String clientName = st.nextToken();
            String clientPass = st.nextToken();

            // Check if user name and password are valid
            if (clientName.equals(USER_NAME) && clientPass.equals(PASS_WORD)) {
                out.println("Welcome " + clientName);
            } else {
                out.println("Access denied");
            }

            // Close connection
            socket.close();
        }
    }
}