import java.io.*;
import java.net.*;

public class java_03899_SocketServer_A07 {
    private static final String SHARED_SECRET = "my_shared_secret";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            if ("AUTH ".concat(message).equals(message)) {
                String clientSecret = in.readUTF();
                if (clientSecret.equals(SHARED_SECRET)) {
                    out.writeUTF("OK");
                } else {
                    out.writeUTF("ERROR");
               
            }
        }
    }
}