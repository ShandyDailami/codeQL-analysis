import java.io.*;
import java.net.*;
import java.util.*;

public class java_15556_SocketServer_A07 {
    private static final String AUTH_USER = "user";
    private static final String AUTH_PASS = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client accepted");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String auth = in.readUTF();

        if (auth.equals(AUTH_USER + ":" + AUTH_PASS)) {
            out.writeUTF("OK");
        } else {
            out.writeUTF("FAIL");
        }

        socket.close();
    }
}