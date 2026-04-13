import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32862_SocketServer_A03 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4444;
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server started at port " + SERVER_PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            if ((clientMessage = in.readLine()) != null) {
                if ("exit".equals(clientMessage)) {
                    System.out.println("Client disconnected");
                    return;
                }

                if (!authenticate(clientMessage)) {
                    out.println("Authentication failed");
                    out.close();
                    continue;
                }

                out.println("Hello, client!");
            }

            out.close();
            socket.close();
        }
    }

    private static boolean authenticate(String input) {
        String[] parts = input.split(":");
        if (parts.length != 2) {
            return false;
        }

        String user = parts[0];
        String password = parts[1];

        return user.equals(AUTH_USER) && password.equals(AUTH_PASSWORD);
    }
}