import java.net.*;
import java.io.*;

public class java_32214_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

            // Authentication
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send auth type and size to client
            out.writeUTF("AUTH");
            out.writeInt(socket.getInputStream().available());

            // Read client's username and password
            String clientInput = in.readLine();
            String[] credentials = clientInput.split(" ");
            String username = credentials[0];
            String password = credentials[1];

            // Compare with stored credentials
            if (username.equals("user") && password.equals("pass")) {
                out.writeUTF("AUTH_SUCCESS");
            } else {
                out.writeUTF("AUTH_FAIL");
              }
            out.flush();
        }
    }
}