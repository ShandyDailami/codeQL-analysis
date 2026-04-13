import java.io.*;
import java.net.*;
import java.util.*;

public class java_40378_SocketServer_A07 {
    private static final String MESSAGE_CORRESPONDING_TO_AUTH_FAILURE = "The authentication failed. Please try again.";
    private static final String AUTH_FAILURE_COUNTDOWN = "Authentication failed, retrying in ";
    private static final String AUTH_SUCCESS = "Authentication successful.";

    private static boolean auth(String user, String pass) {
        // This is a dummy authentication method. It should be replaced with a more secure method.
        return user.equals("admin") && pass.equals("password");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);

        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            String[] requestParts = request.split(" ");
            if (requestParts.length != 2 || !requestParts[0].equals("A07_AuthFailure")) {
                out.writeUTF("INVALID_REQUEST");
                out.flush();
                continue;
            }

            String user = requestParts[1];
            if (!auth(user, "password")) {
                out.writeUTF(AUTH_FAILURE_COUNTDOWN + "5s");
                out.flush();
                continue;
            }

            out.writeUTF(AUTH_SUCCESS);
            out.flush();

            socket.close();
        }
    }
}