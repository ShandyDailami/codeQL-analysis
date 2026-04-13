import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class java_15626_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication succeeded!";
    private static final String AUTHENTICATION_FAILURE = "Authentication failed!";

    private static String md5(String string) {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(string.getBytes("UTF-8"));
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }

    public static void handleClient(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF(AUTHENTICATION_SUCCESS);
        String clientInput = in.readUTF();

        if (md5(clientInput).equals(md5("password"))) {
            out.writeUTF(AUTHENTICATION_SUCCESS);
        } else {
            out.writeUTF(AUTHENTICATION_FAILURE);
        }

        out.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();
            new Thread(() -> {
                try {
                    handleClient(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}