import java.io.*;
import java.net.*;
import java.util.*;

public class java_06854_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String authRequest = input.readUTF();
            System.out.println("Received auth request: " + authRequest);

            if (validateUser(authRequest)) {
                System.out.println("Authentication successful. Sending response...");
                output.writeUTF(AUTH_FAILURE);
                output.flush();
            } else {
                System.out.println("Authentication failed. Sending response...");
                output.writeUTF("FAILURE");
                output.flush();
            }

            socket.close();
        }
    }

    private static boolean validateUser(String authRequest) {
        // This is a simplistic way of doing authentication.
        // In a real world scenario, you would need to use a more secure method.
        // For example, you would hash the user's password and compare it to the stored hash.
        return "username".equals(authRequest);
    }
}