import java.io.*;
import java.net.*;
import javax.security.auth.*;

public class java_28672_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket client = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String request = in.readLine();
            out.println("Hello, client");

            // A07_AuthFailure: Authentication failure
            if (!authenticate(request)) {
                out.println("Authentication failed");
                client.close();
                continue;
            }

            out.println("Authentication successful");
            client.close();
        }
    }

    private static boolean authenticate(String request) {
        // Simulate authentication process by comparing the request with a hardcoded username and password
        String username = request.split(" ")[0];
        String password = request.split(" ")[1];

        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        return username.equals(hardcodedUsername) && password.equals(hardcodedPassword);
    }
}