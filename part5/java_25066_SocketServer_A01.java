import java.io.*;
import java.net.*;

public class java_25066_SocketServer_A01 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String username = reader.readLine();
        String password = reader.readLine();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            writer.println("Access granted");
        } else {
            writer.println("Access denied");
        }

        socket.close();
    }
}