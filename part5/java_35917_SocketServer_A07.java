import java.io.*;
import java.net.*;
import java.util.*;

public class java_35917_SocketServer_A07 {
    private static final String AUTHENTICATION_FAILURE = "Authentication failure!";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected...");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readLine();
                System.out.println("Client message: " + clientMessage);

                String usernamePassword = clientMessage.split(" ")[0];
                String password = clientMessage.split(" ")[1];

                if (usernamePassword.equals(USERNAME) && password.equals(PASSWORD)) {
                    out.writeBytes("Authentication successful\n");
                } else {
                    out.writeBytes(AUTHENTICATION_FAILURE + "\n");
                }

                out.close();
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
}