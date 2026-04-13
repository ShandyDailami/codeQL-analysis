import java.io.*;
import java.net.*;

public class java_18992_SocketServer_A01 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port: " + 4444);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.writeUTF("Authentication successful");
                out.flush();
            } else {
                out.writeUTF("Authentication failed");
                out.flush();
                socket.close();
            }
        }
    }
}