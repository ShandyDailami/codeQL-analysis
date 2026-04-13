import java.io.*;
import java.net.*;
import java.util.*;

public class java_32505_SocketServer_A03 {
    // Constant for the port number
    public static final int port = 4445;

    // Static credentials
    public static String correctUsername = "test";
    public static String correctPassword = "password";

    public static void main(String args[]) {
        ServerSocket server = null;

        try {
            // Step 1: Bind the server to a port
            server = new ServerSocket(port);

            while (true) {
                // Step 2: Listen for client connections
                Socket client = server.accept();

                // Step 3: Get the input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Step 4: Handle the connection (login)
                String clientRequest = in.readLine();
                StringTokenizer st = new StringTokenizer(clientRequest);

                String clientUsername = st.nextToken();
                String clientPassword = st.nextToken();

                // Check if the client's credentials match the expected values
                if (clientUsername.equals(correctUsername) && clientPassword.equals(correctPassword)) {
                    out.writeBytes("Authentication successful\n");
                } else {
                    out.writeBytes("Authentication failed\n");
                }

                // Close the connection
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { server.close(); } catch (IOException e) {}
        }
    }
}