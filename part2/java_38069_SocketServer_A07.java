import java.io.*;
import java.net.*;

public class java_38069_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);

        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMsg = in.readLine();
            System.out.println("Client says: " + clientMsg);

            String username = clientMsg.split(" ")[0];
            String password = clientMsg.split(" ")[1];

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                out.println("Access granted");
            } else {
                out.println("Access denied");
           
            }
        }
    }
}