import java.io.*;
import java.net.*;
import java.util.*;

public class java_36458_SocketServer_A07 {

    private static final String AUTH_SUCCESS = "Auth Success";
    private static final String AUTH_FAILURE = "Auth Failure";

    private static String checkAuth(String username, String password) {
        // Simulate authentication by comparing username and password.
        // In real world, this would be a more complex process.
        if (username.equals("admin") && password.equals("password")) {
            return AUTH_SUCCESS;
        } else {
            return AUTH_FAILURE;
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            Socket client = server.accept();

            // Send the authentication status to the client.
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String authStatus = checkAuth(client.getInetAddress().getHostName(), "password");
            out.println(authStatus);

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Read the message from the client.
            String line = in.readLine();
            System.out.println("Received: " + line);

            client.close();
        }
    }
}