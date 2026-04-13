import java.io.*;
import java.net.*;

public class java_10461_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(65000);

        while (true) {
            Socket client = server.accept();

            // create a writer to send a response back to the client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // create a reader to receive the client's message
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // wait for a client message
            String clientMessage = in.readLine();

            // hardcode username and password
            String username = "user";
            String password = "pass";

            if (clientMessage.equals(username) && authenticate(password)) {
                out.println("Welcome!");
            } else {
                out.println("Authentication failed.");
            }

            // close the connection
            client.close();
        }
    }

    private static boolean authenticate(String password) {
        // This is a simple password verification. In real-world applications, you should use a secure method.
        // For this example, we just check if the password is "pass".
        return password.equals("pass");
    }
}