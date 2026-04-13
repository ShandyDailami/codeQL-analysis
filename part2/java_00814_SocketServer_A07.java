import java.io.*;
import java.net.*;

public class java_00814_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientUsername = in.readUTF();
                String clientPassword = in.readUTF();

                if (authenticate(clientUsername, clientPassword)) {
                    out.writeUTF("Authentication successful!");
                } else {
                    out.writeUTF("Authentication failed!");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}