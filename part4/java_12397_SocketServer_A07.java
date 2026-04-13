import java.io.*;
import java.net.*;
import java.util.*;

public class java_12397_SocketServer_A07 {
    static int port = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authentication
            String username = in.readUTF();
            String password = in.readUTF();

            if (username.equals("admin") && password.equals("password")) {
                out.writeUTF("AuthSuccess");
            } else {
                out.writeUTF("AuthFailure");
            }

            socket.close();
        }
    }
}