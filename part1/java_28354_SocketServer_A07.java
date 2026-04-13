import java.io.*;
import java.net.*;

public class java_28354_SocketServer_A07 {
    private static final String AUTHENTICATE_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String request = in.readUTF();
                System.out.println("Request received: " + request);

                if (handleAuthentication(request)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF(AUTHENTICATE_FAILURE);
                }

                out.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean handleAuthentication(String request) {
        // Basic authentication: check if the request is "username:password"
        String[] credentials = request.split(":");
        if (credentials.length != 2 || credentials[0].isEmpty() || credentials[1].isEmpty()) {
            return false;
        }

        // This is a simplistic way to verify authentication. In a real-world scenario, you'd want to store passwords securely and use a more secure method for authentication.
        return credentials[0].equals("admin") && credentials[1].equals("password");
    }
}