import java.io.*;
import java.net.*;

public class java_30163_SocketServer_A07 {
    private static final String PASSWORD = "secret";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String password = in.readLine();
            System.out.println("Received password: " + password);

            if (PASSWORD.equals(password)) {
                out.writeBytes("Authentication successful\n");
            } else {
                out.writeBytes("Authentication failed\n");
            }

            socket.close();
        }
    }
}