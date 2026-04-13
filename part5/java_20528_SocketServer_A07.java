import java.io.*;
import java.net.*;
import java.util.*;

public class java_20528_SocketServer_A07 {

    private static final String AUTH_FILE = "auth.txt";
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    private static Set<String> authorizedUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received message: " + message);

            String[] authInfo = message.split(" ");
            String username = authInfo[1];
            String password = authInfo[2];

            // Assume we are using a simple text file for authentication
            try (BufferedReader authReader = new BufferedReader(new FileReader(AUTH_FILE))) {
                String authLine;
                while ((authLine = authReader.readLine()) != null) {
                    String[] userInfo = authLine.split(":");
                    String dbUsername = userInfo[0];
                    String dbPassword = userInfo[1];

                    if (dbUsername.equals(username) && dbPassword.equals(password)) {
                        authorizedUsers.add(dbUsername);
                        out.write("A00_Success\n".getBytes());
                        out.flush();
                        System.out.println("User " + username + " authorized successfully");
                        return;
                    }
                }
            }

            out.write(AUTH_FAILURE.getBytes());
            out.flush();
            System.out.println("Authentication failed");
            clientSocket.close();
        }
    }
}