import java.io.*;
import java.net.*;
import java.util.*;

public class java_32663_SocketServer_A08 {
    private static final int DEFAULT_PORT = 1234;

    private static byte[] receiveMD5(Socket sock, int len) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(len);
        byte[] buf = new byte[1024];
        int total = 0, lenRead;
        while (total < len) {
            lenRead = sock.getInputStream().read(buf);
            if (lenRead <= 0) break;
            total += lenRead;
            baos.write(buf, 0, lenRead);
        }
        return baos.toByteArray();
    }

    private static boolean validateMD5(Socket sock, byte[] expected) throws IOException {
        byte[] actual = receiveMD5(sock, expected.length);
        if (Arrays.equals(actual, expected)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(DEFAULT_PORT);
        System.out.println("Secure server started on port " + DEFAULT_PORT);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");
            try {
                if (!validateMD5(socket, getMD5("Hello, world!"))) {
                    throw new IOException("MD5 check failed.");
                }
            } catch (IOException e) {
                System.out.println("Client " + socket.getRemoteSocketAddress() + " failed MD5 check: " + e.getMessage());
            }
        }
    }

    private static byte[] getMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(data.getBytes());
    }
}