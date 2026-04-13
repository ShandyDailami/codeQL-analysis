import java.net.*;
import java.io.*;
import java.util.*;

public class java_01522_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "AuthenticatedUser";
    private static Set<String> authorizedUsers = new HashSet<>(Arrays.asList(AUTHENTICATED_USER));

    public static void main(String[] args) {
        int port = 5000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port + "...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readLine();
                String[] tokens = request.split(" ");
                String user = tokens[1];

                if (authorizedUsers.contains(user)) {
                    out.writeBytes("Hello " + user + "!\n");
                } else {
                    out.writeBytes("Unauthorized attempt\n");
                }

                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* couldn't do anything */ }
            }
        }
    }
}