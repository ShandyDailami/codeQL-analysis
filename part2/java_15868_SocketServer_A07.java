import java.io.*;
import java.net.*;
import java.util.*;

public class java_15868_SocketServer_A07 {
    private static String FAILURE_RESPONSE = "AuthFailure";
    private static String SUCCESS_RESPONSE = "AuthSuccess";
    private static String USERNAME = "user";
    private static String PASSWORD = "pass";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientUsername = in.readUTF();
                String clientPassword = in.readUTF();

                if (authenticate(clientUsername, clientPassword)) {
                    out.writeUTF(SUCCESS_RESPONSE);
                } else {
                    out.writeUTF(FAILURE_RESPONSE);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}