import java.io.*;
import java.net.*;

public class java_34191_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String INCORRECT_USERNAME_PASSWORD = "Incorrect Username or Password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String usernamePassword = in.readLine();

            String[] credentials = usernamePassword.split(":");

            String username = credentials[0];
            String password = credentials[1];

            if (username.equals("admin") && password.equals("password")) {
                out.writeBytes("Access granted\n");
            } else {
                out.writeBytes(INCORRECT_USERNAME_PASSWORD + "\n");
            }

            socket.close();
        }
    }
}