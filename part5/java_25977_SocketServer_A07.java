import java.io.*;
import java.net.*;
import java.util.*;

public class java_25977_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static boolean authenticated = false;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received message: " + message);

            if (authenticateClient(message)) {
                out.writeBytes("Authenticated\n");
            } else {
                out.writeBytes("Failed to authenticate\n");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(String message) {
        if (message.equals("password")) {
            authenticated = true;
        }
        return authenticated;
    }
}