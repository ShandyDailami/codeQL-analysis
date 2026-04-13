import java.io.*;
import java.net.*;
import java.util.*;

public class java_41337_SocketServer_A07 {
    private static final String AUTH_USER = "test";
    private static final String AUTH_PWD = "test";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress() + " connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            System.out.println("Received client message: " + clientMsg);

            String authMsg = in.readUTF();
            String[] authDetails = authMsg.split(":");

            if (authenticate(authDetails[0], authDetails[1])) {
                out.writeUTF("Auth successful");
            } else {
                out.writeUTF("Auth failed");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(AUTH_USER) && password.equals(AUTH_PWD);
    }
}