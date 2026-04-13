import java.io.*;
import java.net.*;
import java.util.*;

public class java_28515_SocketServer_A01 {
    private static final String SERVER_SOFTWARE = "SecureServer/1.0";

    private static final String AUTH_FAILED = "Authentication failed";
    private static final String AUTH_SUCCESSFUL = "Authentication successful";

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = in.readLine();
                System.out.println("Client message: " + clientMessage);

                String serverMessage;

                if ("user".equals(clientMessage)) {
                    out.writeBytes(AUTH_SUCCESSFUL + "\n");
                } else {
                    out.writeBytes(AUTH_FAILED + "\n");
                }

                clientSocket.close();
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