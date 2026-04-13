import java.io.*;
import java.net.*;
import java.util.*;

public class java_21637_SocketServer_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientUsername = dis.readUTF();
            String clientPassword = dis.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                dos.writeUTF("Authorized");
            } else {
                dos.writeUTF("Unauthorized");
            }

            dos.close();
            socket.close();
        }
    }
}