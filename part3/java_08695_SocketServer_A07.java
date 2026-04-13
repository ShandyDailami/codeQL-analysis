import java.io.*;
import java.net.*;
import java.util.*;

public class java_08695_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "user";

    private static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server started on port: 5555");

        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

                String request;
                while ((request = in.readLine()) != null) {
                    if (!authenticate(request.split(" ")[0], request.split(" ")[1])) {
                        out.println("Invalid credentials");
                        out.flush();
                        continue;
                    }
                    out.println("Access granted");
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}