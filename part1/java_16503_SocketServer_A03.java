import java.io.*;
import java.net.*;
import java.util.*;

public class java_16503_SocketServer_A03 {
    private static List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            if(isValidPassword(clientMessage)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidPassword(String password) {
        return validPasswords.contains(password);
    }
}