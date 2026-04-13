import java.io.*;
import java.net.*;

public class java_07621_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Auth successful";
    private static final String AUTH_FAILURE = "Auth failed";
    private static final String AUTH_USERNAME = "user";
    private static final String AUTH_PASSWORD = "pass";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234); // Bind to port 1234
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                // Authentication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                String password = in.readUTF();

                if (authenticate(username, password)) {
                    out.writeUTF(AUTH_SUCCESS);
                } else {
                    out.writeUTF(AUTH_FAILURE);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        return AUTH_USERNAME.equals(username) && AUTH_PASSWORD.equals(password);
    }
}