import java.io.*;
import java.net.*;

public class java_26580_SocketServer_A01 {
    private static final String AUTHORIZED_USER = "admin";
    private static final String AUTHORIZED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            Socket client = server.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read username and password from client
            String clientUser = in.readLine();
            String clientPassword = in.readLine();

            if (!isAuthorized(clientUser, clientPassword)) {
                out.writeBytes("Login failed. Username or password is incorrect.\n");
                client.close();
                continue;
            }

            // Read message from client
            String message = in.readLine();

            // Echo message back to client
            out.writeBytes(message + "\n");

            client.close();
        }
    }

    private static boolean isAuthorized(String user, String password) {
        return user.equals(AUTHORIZED_USER) && password.equals(AUTHORIZED_PASSWORD);
    }
}