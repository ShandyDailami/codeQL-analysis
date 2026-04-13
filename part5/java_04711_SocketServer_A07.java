import java.io.*;
import java.net.*;
import java.util.*;

public class java_04711_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    private static String getPassword(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String password = reader.readLine();
            return password;
        } catch (IOException e) {
            return "";
        }
    }

    private static boolean authenticate(Socket socket) {
        return getPassword(socket).equals(PASSWORD);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            if (authenticate(socket)) {
                OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("Hello, Client!");
                writer.flush();
            } else {
                socket.close();
                System.out.println("Authentication failed!");
            }
        }
    }
}