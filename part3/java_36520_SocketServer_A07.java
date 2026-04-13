import java.io.*;
import java.net.*;

public class java_36520_SocketServer_A07 {

    // Create a static buffer
    private static final String PASSWORD = "securepassword";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client...");

        // Maintain server status
        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected!");

            // Create streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username and password from client
            String clientInput = in.readLine();
            String[] credentials = clientInput.split(" ");
            String clientUsername = credentials[0];
            String clientPassword = credentials[1];

            // Check if credentials are correct
            if (clientUsername.equals("secureuser") && clientPassword.equals(PASSWORD)) {
                out.writeBytes("Connection Successful\n");
            } else {
                out.writeBytes("Connection Failed\n");
            }

            // Close streams
            in.close();
            out.close();
            socket.close();
        }
    }
}