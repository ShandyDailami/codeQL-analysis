import java.io.*;
import java.net.*;
import java.util.*;

public class java_40860_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);

        while (true) {
            Socket socket = server.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine();
        StringTokenizer st = new StringTokenizer(message);

        String clientUser = st.nextToken();
        String clientPassword = st.nextToken();

        if (!authenticate(clientUser, clientPassword)) {
            out.println("Auth failure");
            out.flush();
            socket.close();
            return;
        }

        out.println("Auth successful");
        out.flush();
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}