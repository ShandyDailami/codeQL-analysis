import java.io.*;
import java.net.*;
import java.util.*;

public class java_40608_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                if ("exit".equals(clientMessage)) {
                    out.println("Goodbye!");
                    break;
                }

                String[] authParts = clientMessage.split(" ");
                if (authParts.length != 2) {
                    out.println("Bad request. Usage: LOGIN username password");
                    continue;
                }

                String clientUsername = authParts[1];
                String clientPassword = authParts[2];

                if (!AUTHENTICATED_USER.equals(clientUsername)
                        || !AUTHENTICATED_PASSWORD.equals(clientPassword)) {
                    out.println("Bad username or password!");
                    continue;
                }

                out.println("Welcome, " + clientUsername);
            }

            clientSocket.close();
        }
    }
}