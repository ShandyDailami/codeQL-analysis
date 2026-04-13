import java.io.*;
import java.net.*;

public class java_30887_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started at port 8189.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String username = input.readUTF();
            String password = input.readUTF();

            if (authenticate(username, password)) {
                output.writeUTF("Authentication successful");
            } else {
                output.writeUTF("Authentication failed");
           
            }

            output.close();
            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}