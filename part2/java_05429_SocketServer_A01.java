import java.io.*;
import java.net.*;

public class java_05429_SocketServer_A01 {
    private static final String PASSWORD = "securePassword";
    private static final int PORT = 4445;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientPassword = in.readLine();

            if (clientPassword.equals(PASSWORD)) {
                out.writeBytes("Access granted\n");
            } else {
                out.writeBytes("Access denied\n");
            }

            socket.close();
        }
    }
}