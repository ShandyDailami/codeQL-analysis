import java.io.*;
import java.net.*;

public class java_13788_SocketServer_A08 {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
           
                socket.close();
                continue;
            }

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            out.writeUTF("Server says: Hello, " + message);
            socket.close();
        }
    }
}