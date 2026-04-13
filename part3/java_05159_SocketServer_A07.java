import java.io.*;
import java.net.*;
import java.util.*;

public class java_05159_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private static String readString(DataInputStream in) throws IOException {
        int length = in.readInt();
        byte[] messageBytes = new byte[length];
        in.readFully(messageBytes, 0, length);
        return new String(messageBytes, "UTF-8");
    }

    private static void writeString(DataOutputStream out, String message) throws IOException {
        out.writeInt(message.length());
        out.writeBytes(message);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for a client ...");

        Socket socket = server.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // First message is the username and password
        writeString(out, USERNAME);
        String username = readString(in);
        writeString(out, PASSWORD);
        String password = readString(in);

        // Check if username and password match
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            writeString(out, "Authentication successful!");
        } else {
            writeString(out, "Authentication failed!");
        }

        out.close();
        in.close();
        socket.close();
        server.close();
    }
}