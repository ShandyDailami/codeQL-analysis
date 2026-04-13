import java.io.*;
import java.net.*;
import java.util.*;

public class java_23611_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String receivedUsername = in.readUTF();
            String receivedPassword = in.readUTF();

            if (!receivedUsername.equals(USERNAME) || !receivedPassword.equals(PASSWORD)) {
                out.writeUTF("Authentication failure");
                out.flush();
                socket.close();
            } else {
                out.writeUTF("Authentication successful");
                out.flush();
            }
        }
    }
}