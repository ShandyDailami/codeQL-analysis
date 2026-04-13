import java.io.*;
import java.net.*;
import java.util.*;

public class java_02066_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);

        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username and password from client
            String clientUsername = in.readLine();
            String clientPassword = in.readLine();

            // Check if username and password match
            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.writeBytes("Authentication successful\n");
            } else {
                out.writeBytes("Authentication failed\n");
                socket.close();
                continue;
            }

            // Read and send data from client
            String clientData = in.readLine();
            out.writeBytes(clientData + "\n");

            // Close the socket
            socket.close();
        }
    }
}