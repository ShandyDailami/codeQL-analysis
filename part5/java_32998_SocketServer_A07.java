import java.io.*;
import java.net.*;

public class java_32998_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read username and password from client
                String clientUsername = in.readLine();
                String clientPassword = in.readLine();

                // validate username and password
                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    out.writeBytes("Authentication successful\n");
                } else {
                    out.writeBytes("Authentication failed\n");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}